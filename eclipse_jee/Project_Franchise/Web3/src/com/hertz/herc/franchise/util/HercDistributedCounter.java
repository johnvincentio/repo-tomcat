package com.hertz.herc.franchise.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TimeZone;

public class HercDistributedCounter {

	private static final int COUNTER_IP_OCTETS_TO_USE = 1;
	private static final int COUNTER_MAX = 99999;
	private static final int DATE_MAX_POSITIONS_DAY = 4;
	private static final int DATE_MAX_POSITIONS_SECOND = 5;
	private static final int JVM_MAX = 99;
	private static final int NANO_TIMEOUT = (1000000000 / COUNTER_MAX);

	private static final long MILLISECONDS_PER_DAY = 86400000;
	private static final long DISTRIBUTED_TIMEOUT = 300000;
	private static final long LOCK_TIMEOUT = 30000;

	// These constants below are to determine a start date for unique number generation...
	// altering them could result in the generation of duplicate items.
	// *****************************************************************************
	// ****DO NOT CHANGE THESE VALUES UNLESS YOU KNOW EXACTLY WHAT YOU ARE DOING****
	private static final String DATE_COUNTER_BASE_DAY = "01"; // *************
	private static final String DATE_COUNTER_BASE_MONTH = "01"; // *************
	private static final String DATE_COUNTER_BASE_YEAR = "2006"; // *************
	// *****************************************************************************

	private static final String IP_DELIMITER = ".";
	private static final String IP_PADDED_OCTET = "000";
	private static final String TIME_ZONE = "GMT";

	private static int localCounter = COUNTER_MAX;

	private static String localIPAddress = null;
	private static Object classMutex = new Object ();

	// For use with the getUniqueIdString(...) method.
	private static Object counter2Mutex = new Object ();

	/**
	 * Returns the number of a free jvm counter variable and locks that number from being used by
	 * other processes unless the lock is explicitly released. This method is synchronized so there
	 * can be from 0 to a maximum of JVM_MAX items allowed to generate numbers at any given time.
	 * 
	 * @return - number from 0 to JVM_MAX
	 * @throws Exception
	 * 
	 * @author - Kevin Valentine
	 */
	private static int getDistributedCounter () throws Exception {
		int distributedCounter = 0;
		RandomAccessFile counterFile = null;

		DistributedCounterLock lock = getLock ();

		if (lock == null) { throw new Exception ("Unable to acquire Lock"); }

		for (int i = 0; i < JVM_MAX; i++) {
			boolean stop = false;

			// find an available distributedCounter File
			try {
				counterFile = new RandomAccessFile ("distributedcounter" + i + ".count", "rw");
				long length = counterFile.length ();
				long time = -1;
				long currentTime = System.currentTimeMillis ();

				// if there is a time, let's read it
				if (length > 0) {
					time = counterFile.readLong ();
					counterFile.seek (0);

					// if this fileCounterLock has expired or it is =-1(unused), let's take over it
					if (time == -1 || currentTime - time > DISTRIBUTED_TIMEOUT) {
						counterFile.writeLong (currentTime);
						distributedCounter = i;
						stop = true;
					}

				}
				else {
					// if there is nothing in this file, let's put a lock on it for the next 24 hours
					counterFile.writeLong (currentTime);
					distributedCounter = i;
					stop = true;
				}

			}
			catch (FileNotFoundException fne) {
				fne.printStackTrace ();
				throw new FileNotFoundException ("file Not Found " + fne);
			}
			finally {
				try {
					if (counterFile != null) {
						counterFile.close ();
						if (stop) {
							break;
						}
					}
				}
				catch (Exception e) {
					e.printStackTrace ();
					lock.release ();
					throw e;
				}
			}
		}

		if (distributedCounter == -1) { throw new FileNotFoundException (
				"No free distributedcounter.count file. Increase the max= size in the JvmMax.properties file!"); }

		lock.release ();

		return distributedCounter;
	}

	/**
	 * Generates a lock file on the local system which can only be held by one process at a time. If
	 * another thread already has posession of this file then the requesting process will wait up to
	 * LOCK_TIMEOUT milliseconds for the lock to be released before returning.
	 * 
	 * @return the lock if it was obtained, null otherwise
	 * @throws Exception
	 */
	private static synchronized DistributedCounterLock getLock () throws Exception {
		try {
			File file = new File ("count.lock");
			FileChannel channel = new RandomAccessFile (file, "rw").getChannel ();
			FileLock lock;

			long startTime = System.currentTimeMillis ();

			while (true) {
				try {
					lock = channel.tryLock ();

					if (lock != null) { return new DistributedCounterLock (channel, lock); }
				}
				catch (Exception e) {

				}

				// if waited greater than 30 seconds
				if (System.currentTimeMillis () - startTime > LOCK_TIMEOUT) { return null; }

				Thread.sleep (10);
			}

		}
		catch (IOException ioe) {
			ioe.printStackTrace ();
			return null;
		}
	}

//	/**
//	 * Removes the lock file created on the local system thereby freeing up the lock for use by
//	 * other processes.
//	 *
//	 * @return true once lock file is removed.
//	 */
//	private static boolean releaseLock(){
//		File lock = new File("count.lock");
//		lock.delete();
//
//		return true;
//	}

	/**
	 * Whenever this object is garbage collected, the finalize method is called and the counter
	 * value will be written back to disk for future useage.
	 * 
	 */
	protected void finalize () throws Throwable {
		super.finalize ();

	}

	/**
	 * Frees up the jvm counter retreived by the DistributedCounter.getDistributedCounter() method
	 * allowing other process to acquire and lock this jvm counter number in order to generate
	 * unique numbers.
	 * 
	 * @param distributedCounter - number of jvm counter object to be released
	 * @return - true if successful.
	 * @throws Exception
	 * 
	 * @author - Kevin Valentine
	 */
	private static boolean releaseDistributedCounter (int distributedCounter) throws Exception {
		RandomAccessFile counterFile = null;

		DistributedCounterLock lock = getLock ();

		if (lock == null) { throw new Exception ("Unable to acquire Lock"); }

		try {
			// opening counterbootstrap file to initialize the counter.
			counterFile = new RandomAccessFile ("distributedcounter" + distributedCounter + ".count", "rwd");
			counterFile.writeLong (-1);

		}
		catch (FileNotFoundException fne) {
			throw new NumberFormatException ("DistributedCounter.finalize(): Unable to save counter to file" + fne);
		}
		catch (IOException ioe) {
			throw new NumberFormatException ("DistributedCounter.finalize(): Unable to save counter to file" + ioe);
		}
		finally {
			try {
				counterFile.close ();
			}
			catch (Exception e) {
				e.printStackTrace ();
			}
			finally {
				lock.release ();
			}
		}

		return true;
	}

	/**
	 * This method will generate a counter in a string with fixed length of maxSize bytes.
	 * 
	 * @param counter - integer value to be converted to string
	 * @param maxSize - maximum size of string to be returned (will be taken from right-most digits).
	 * @return - String representation of [counter] value with a length of [maxSize]
	 */
	private static String getCounterStringValue (int counter, int maxSize) throws ArrayIndexOutOfBoundsException {
		String counterString = Integer.toString (counter);
		int length = counterString.length ();
		StringBuffer filler = new StringBuffer (maxSize);

		if (length > maxSize) { return counterString.substring ((length - maxSize), length); }

		int fillerSize = maxSize - length;

		while (fillerSize > 0) {
			filler.append ("0");
			fillerSize--;
		}
		return filler.toString () + counterString;
	}

	/**
	 * Generates a unique number with a base including the IP Address of the server to ensure uniqueness
	 * across multiple concurrent instances.
	 * 
	 * @param ipAddress - 4 octet IP address to ensure uniqueness across multiple instances.
	 * @return - String containing a unique number.
	 * @throws HertzSystemException
	 * 
	 * @author Kevin Valentine
	 */
	public static String getUniqueNumberForIP (String ipAddress) throws Exception {

		try {
			return getValue (ipAddress, COUNTER_IP_OCTETS_TO_USE);
		}
		catch (Exception ex) {
			throw new Exception (ex.getMessage ());
		}
	}

	/**
	 * Generates a unique number with a base including the IP Address of the server to ensure uniqueness
	 * across multiple concurrent instances. IP Address is retrieved from the local system.
	 * 
	 * @return - String containing a unique number.
	 * @throws HertzSystemException
	 * 
	 * @author Kevin Valentine
	 */
	public static String getUniqueNumber () throws Exception {

		try {
			if (localIPAddress == null) {
				localIPAddress = InetAddress.getLocalHost ().getHostAddress ();
			}

			return getValue (localIPAddress, COUNTER_IP_OCTETS_TO_USE);
		}
		catch (UnknownHostException ex) {
			throw new Exception (ex.getMessage ());
		}
		catch (Exception ex) {
			throw new Exception (ex.getMessage ());
		}
	}

	/**
	 * Generates a random String of 'length' size using uppercase/lowercase characters as well as numbers. The
	 * maximum amount of unique numbers that can be generated per day for any given length will be determined by
	 * 62^n (36^n when caseSensitive == true) where n = length - 2. The potential for duplication is present
	 * roughly 10.53 years after 01/01/2006<--(as set in the constants at top) for any given length (3.55 years
	 * after 01/01/2006 if caseSensitive == true).
	 * 
	 * @param length - Length of String to be returned, minimum length is 3.
	 * @param caseSensitive - Set to true to have case sensitive results (uppercase characters and numbers only).
	 * @return - Generated String based on input parameters.
	 * @throws HertzSystemException
	 * 
	 * @author Kevin Valentine
	 * @update 05/30/2007 - Added caseSensitive parameter; updated tracking file names to include length and case-sensitive
	 *         - data in the title to ensure complete uniqueness on any given day.
	 */
	public static String getUniqueIdString (int length, boolean caseSensitive) throws Exception {
		int curDate = 0;
		int digitValue = 0;
		int i = 0;
		int keySize = 0;
		int localCounter2 = -1;
		int savedDate = 0;

		long tempNumber = 0;

		ArrayList keySet = new ArrayList ();

		BufferedReader in = null;

		BufferedWriter out = null;

		File counterFile = null;

		String result;

		StringBuffer tempStrBuffer = new StringBuffer ();
		StringBuffer resultStrBuffer = new StringBuffer ();

		// A valid number has to have a length of 3 or greater.
		if (length < 3) { return null; }

		// Create collections for the different types of available characters and populate.
		// Numbers
		for (i = 48; i < 58; i++) {
			keySet.add ("" + (char) i);
		}
		// Uppercase characters.
		for (i = 65; i < 91; i++) {
			keySet.add ("" + (char) i);
		}
		if (!caseSensitive) {
			// Lowercase characters
			for (i = 97; i < 123; i++) {
				keySet.add ("" + (char) i);
			}
		}

		// Store the size of our keySet ArrayList for future use.
		keySize = keySet.size ();

		curDate = Integer.parseInt (getDateString ()) % (keySize * keySize);
		// tempNumber used in order to preserve curDate value.
		tempNumber = curDate;

		// Convert date into a base-62 number based on our keySet.
		while (tempNumber > 0) {
			digitValue = Integer.parseInt ("" + tempNumber % keySize);
			tempNumber = tempNumber / keySize;
			resultStrBuffer.append (keySet.get (digitValue));
		}

		// Synchronize the main section to ensure the multiple threads cannot write the same data.
		synchronized (counter2Mutex) {
			try {
				// opening counterbootstrap file to initialize the counter.
				counterFile = new File ("counter" + length + (caseSensitive == true ? "cs" : "") + ".day");
				counterFile.createNewFile ();

				in = new BufferedReader (new InputStreamReader (new FileInputStream (counterFile)));

				long fileSize = counterFile.length ();

				// if the file is valid and contains data...
				if (fileSize > 0) {
					String tempStr = "";

					// Get the day marker (frist line).
					tempStr = in.readLine ();

					if (tempStr != null) {
						savedDate = Integer.parseInt (tempStr);
					}

					// Get the counter marker (second line).
					tempStr = in.readLine ();

					if (tempStr != null) {
						localCounter2 = Integer.parseInt (tempStr);
					}

					in.close ();

					out = new BufferedWriter (new FileWriter (counterFile));

					// Verify the date stored is the same as the current date...
					if (savedDate != curDate) {
						// if not we need to reset the static counter and update the date in the file.
						// Choose a random place to start our counter if resetting.
						// lc2 = new Random().nextInt((keySize * keySize));
						localCounter2 = new Random ().nextInt ((int) Math.pow (keySize, length - resultStrBuffer.length ()));
					}
					else if (-1 == localCounter2) {
						// Choose a random place to start our counter if resetting.
						localCounter2 = new Random ().nextInt ((int) Math.pow (keySize, length - resultStrBuffer.length ()));
					}
					else {
						localCounter2++;
					}

					// write out the revised day and count markers.
					out.write (curDate + "\n" + localCounter2 + "\n");
				}
				else {
					// if there is nothing in this file, let's put a lock on it for the next 24 hours
					// Choose a random place to start our counter if resetting.
					in.close ();

					localCounter2 = new Random ().nextInt ((int) Math.pow (keySize, length - resultStrBuffer.length ()));

					// write out the revised day and count markers.
					out = new BufferedWriter (new FileWriter (counterFile));
					out.write (curDate + "\n" + localCounter2 + "\n");
				}

				out.close ();

				// tempNumber used in order to preserve counter value.
				tempNumber = localCounter2 % (keySize * keySize);

				// Convert counter into a base-62 number based on our keySet.
				while (tempNumber > 0) {
					digitValue = Integer.parseInt ("" + tempNumber % keySize);
					tempNumber = tempNumber / keySize;

					tempStrBuffer.append (keySet.get (digitValue));
				}

				if (tempStrBuffer.length () + resultStrBuffer.length () < length) {
					// Left-pad the result string with zeros if the counter will not fill it to the requested length.
					for (i = tempStrBuffer.length () + resultStrBuffer.length (); i < length; i++) {
						resultStrBuffer.append ("0");
					}
					// Add to result buffer.
					resultStrBuffer.append (tempStrBuffer);
				}
				else {
					// Add to result buffer, truncating any excess high-order characters.
					resultStrBuffer.append (tempStrBuffer.substring (tempStrBuffer.length () - length + resultStrBuffer.length ()));
				}

				result = resultStrBuffer.toString ();

			}
			catch (FileNotFoundException fne) {
				throw new NumberFormatException ("DistributedCounter.finalize(): Unable to save counter to file" + fne);
			}
			catch (IOException ioe) {
				throw new NumberFormatException ("DistributedCounter.finalize(): Unable to save counter to file" + ioe);
			}
			catch (Exception e) {
				throw new Exception ("Unknown error generating unique String" + e);
			}
			finally {
				try {
					// Ensure file is closed for use by other threads.
					in.close ();
					out.close ();

				}
				catch (Exception e) {
					e.printStackTrace ();
					throw e;
				}
			}
		}

		return result;

	}

	/**
	 * Method generates a completely unique number.
	 * 
	 * @param ipAddress - 4 octet IP address to ensure uniqueness across multiple instances.
	 * @param ipOctetsToUse - Number of octets to use to ensure uniqueness across multiple instances (4 = Complete IP Address, 3 = Last 3 Octets, 2 =
	 *        Last 2 Octets, 1 = Last Octet Only)
	 * @return - String containing a unique number.
	 * @throws HertzSystemException
	 * 
	 * @author Kevin Valentine
	 */
	private static String getValue (String ipAddress, int ipOctetsToUse) throws Exception {
		int distributedCounter = -1;
		String date;
		String time;
		String localCtr;
		String jvmCtr;
		String ip;

		try {
			distributedCounter = getDistributedCounter ();
		}
		catch (Exception ex) {
			throw ex;
		}

		try {
			if (distributedCounter == -1) { throw new Exception (HercDistributedCounter.class
					+ ": The counter has an illegal value. It may be because the counter failed to Initialize"); }

			synchronized (classMutex) {
				// if counter greater than JVM_COUNTER_MAX, reset to 0
				if (localCounter < COUNTER_MAX) {
					localCounter++;
				}
				else {
					localCounter = 0;
				}

				localCtr = getCounterStringValue (localCounter, String.valueOf (COUNTER_MAX).length ());
				date = getCounterStringValue (Integer.parseInt (getDateString ()), DATE_MAX_POSITIONS_DAY);
				time = getCounterStringValue (Integer.parseInt (getTimeString ()), DATE_MAX_POSITIONS_SECOND);

				// Ensure that we can never overrun (loop) the counter during a single second; completely eliminates
				// potential for duplication regardless of hardware speed or number of requesting threads.
				Thread.sleep (0, NANO_TIMEOUT);
			}

			releaseDistributedCounter (distributedCounter);
			ip = encodeIP (ipAddress, ipOctetsToUse);
			jvmCtr = getCounterStringValue (distributedCounter, String.valueOf (JVM_MAX).length ());

		}
		catch (Exception ex) {
			throw new Exception (HercDistributedCounter.class + " - getValue(...): Error creating unique number:\n" + ex.getMessage ());
		}

		return (ip + localCtr + jvmCtr + date + time);
	}

	/**
	 * Converts normal 12-digit IP address into a compact form with the following properties:
	 * octetsToUse:4 - returns a 10-digit number based on the full IP Address
	 * octetsToUse:3 - returns a 8-digit number based on the last 9-digits of the IP Address
	 * octetsToUse:2 - returns a 5-digit number based on the last 6-digits of the IP Address
	 * octetsToUse:1 - returns a 3-digit number based on the last 3-digits of the IP Address
	 * 
	 * @param ipAddress - The IP address to be formatted; represented by 4 octets with period (.) seperations (xxx.xxx.xxx.xxx) Each octets must
	 *        consist of 1-3 digits.
	 * @param ipOctetsToUse - The number of octets to include (MAX=4) in the formatted String (taken from lowest order through highest order octet).
	 * @return - String containing encoded IP Address
	 * 
	 * @author Kevin Valentine
	 **/
	private static String encodeIP (String ipAddress, int ipOctetsToUse) throws Exception {
		StringTokenizer IPOctets = new StringTokenizer (ipAddress.trim (), IP_DELIMITER);
		StringBuffer IPBuffer = new StringBuffer (15);

		// First we have to ensure that each octet contains 3 digits. Missing digits will be padded with zeros.
		while (IPOctets.hasMoreElements ()) {
			String token = (String) IPOctets.nextElement ();
			// prepare a byte array with "000" string representation in bytes
			byte[] formattedOctet = {0x30, 0x30, 0x30};
			byte[] unformattedOctet = token.getBytes ();

			int j = 2;
			for (int i = (unformattedOctet.length - 1); i >= 0; i--) {

				formattedOctet[j] = unformattedOctet[i];
				j--;
			}

			IPBuffer.append (new String (formattedOctet) + IP_DELIMITER);
		}
		IPBuffer.deleteCharAt (IPBuffer.lastIndexOf (IP_DELIMITER));

		// Test to ensure that the calling method has not passed in an invalid octet count.
		if (ipOctetsToUse > 4) {
			System.err.println (HercDistributedCounter.class
					+ " - encodeIP(...): Inappropriate octet count has been received, using maximum octet count of 4 instead.");
			ipOctetsToUse = 4;
		}

		IPOctets = new StringTokenizer (IPBuffer.toString (), IP_DELIMITER);
		// Create a StringBuffer with the correct size
		IPBuffer = new StringBuffer ((((ipOctetsToUse * 3) / 6) * 5) + (ipOctetsToUse * 3) % 6);

		while (IPOctets.hasMoreTokens ()) {
			if (IPOctets.countTokens () <= ipOctetsToUse && IPOctets.countTokens () > 1) {
				// Convert the high order bit from the next 2 octets from 2 base-10 numbers to a single base-3
				// number. This lowers the storage requirements from 6 to 5 digits for two octets.
				String highOctet = IPOctets.nextToken ();
				String lowOctet = IPOctets.nextToken ();

				String strConv = convertToBase10 (highOctet.substring (0, 1) + lowOctet.substring (0, 1));

				IPBuffer.append (strConv.substring (0, 1));
				IPBuffer.append (highOctet.substring (1));
				IPBuffer.append (lowOctet.substring (1));
			}
			else if (IPOctets.countTokens () <= ipOctetsToUse) {
				IPBuffer.append (IPOctets.nextToken ());
			}
			else {
				IPOctets.nextToken ();
			}

		}

		return IPBuffer.toString ();
	}

	/**
	 * Restores the IP Address from a String that was encoded with the encodeIP method.
	 * 
	 * @param codedIP - String holding coded IP Address.
	 * @return - String holding the restored IP Address portion, all unused/unrestorable octets will be padded with zeros.
	 * 
	 * @author Kevin Valentine
	 */
	private static String decodeIP (String codedIP) throws Exception {
		int length = codedIP.length ();
		StringBuffer IPBuffer = new StringBuffer (15);
		String strConv;
		int highOctetNum;
		int lowOctetNum;

		switch (length) {
			case 3:
				IPBuffer.append (IP_PADDED_OCTET + IP_DELIMITER);
				IPBuffer.append (IP_PADDED_OCTET + IP_DELIMITER);
				IPBuffer.append (IP_PADDED_OCTET + IP_DELIMITER);
				IPBuffer.append (codedIP);
				break;
			case 5:
				strConv = convertToBase3 (codedIP.substring (0, 1));

				IPBuffer.append (IP_PADDED_OCTET + IP_DELIMITER);
				IPBuffer.append (IP_PADDED_OCTET + IP_DELIMITER);
				IPBuffer.append (strConv.substring (0, 1));
				IPBuffer.append (codedIP.substring (1, 3));
				IPBuffer.append (IP_DELIMITER);
				IPBuffer.append (strConv.substring (1, 2));
				IPBuffer.append (codedIP.substring (3, 5));
				break;
			case 8:
				strConv = convertToBase3 (codedIP.substring (0, 1));

				IPBuffer.append (IP_PADDED_OCTET + IP_DELIMITER);
				IPBuffer.append (strConv.substring (0, 1));
				IPBuffer.append (codedIP.substring (1, 3));
				IPBuffer.append (IP_DELIMITER);
				IPBuffer.append (strConv.substring (1, 2));
				IPBuffer.append (codedIP.substring (3, 5));
				IPBuffer.append (IP_DELIMITER);
				IPBuffer.append (codedIP.substring (5, 8));
				break;
			case 10:
				strConv = convertToBase3 (codedIP.substring (0, 1));

				IPBuffer.append (strConv.substring (0, 1));
				IPBuffer.append (codedIP.substring (1, 3));
				IPBuffer.append (IP_DELIMITER);
				IPBuffer.append (strConv.substring (1, 2));
				IPBuffer.append (codedIP.substring (3, 5));
				IPBuffer.append (IP_DELIMITER);
				strConv = convertToBase3 (codedIP.substring (5, 6));

				IPBuffer.append (strConv.substring (0, 1));
				IPBuffer.append (codedIP.substring (6, 8));
				IPBuffer.append (IP_DELIMITER);
				IPBuffer.append (strConv.substring (1, 2));
				IPBuffer.append (codedIP.substring (8, 10));
				break;
			default:
				IPBuffer.append (IP_PADDED_OCTET + IP_DELIMITER);
				IPBuffer.append (IP_PADDED_OCTET + IP_DELIMITER);
				IPBuffer.append (IP_PADDED_OCTET + IP_DELIMITER);
				IPBuffer.append (IP_PADDED_OCTET);
		}

		return IPBuffer.toString ();
	}

	/**
	 * Transforms a single-digit base 10 number (0 - 8) into a two-digit base 3 number.
	 * 
	 * @param num - Single-digit base 10 number to be transformed.
	 * @return - Two-digit base 3 number.
	 * 
	 * @author Kevin Valentine
	 */
	private static String convertToBase3 (String num) throws Exception {
		StringBuffer b3Num = new StringBuffer (2);
		// Convert a single-digit base 10 number to a base 3 number.
		switch (Integer.parseInt (num)) {
			case 0:
				b3Num.append ("00");
				break;
			case 1:
				b3Num.append ("01");
				break;
			case 2:
				b3Num.append ("02");
				break;
			case 3:
				b3Num.append ("10");
				break;
			case 4:
				b3Num.append ("11");
				break;
			case 5:
				b3Num.append ("12");
				break;
			case 6:
				b3Num.append ("20");
				break;
			case 7:
				b3Num.append ("21");
				break;
			case 8:
				b3Num.append ("22");
				break;
			default:
				throw new Exception (HercDistributedCounter.class + " - convertToBase3(...): Number " + num + " is invalid for conversion to base 3");
		}

		return b3Num.toString ();
	}

	/**
	 * Transforms a two-digit base 3 number into a single-digit base 10 number.
	 * 
	 * @param num - Two-digit base 3 number to be transformed.
	 * @return - Single-digit base 10 number.
	 * 
	 * @author Kevin Valentine
	 */
	private static String convertToBase10 (String num) throws Exception {
		StringBuffer b10Num = new StringBuffer (2);
		// Convert a double-digit base 3 number to a single digit base 10 number.
		switch (Integer.parseInt (num)) {
			case 0:
				b10Num.append ("0");
				break;
			case 1:
				b10Num.append ("1");
				break;
			case 2:
				b10Num.append ("2");
				break;
			case 10:
				b10Num.append ("3");
				break;
			case 11:
				b10Num.append ("4");
				break;
			case 12:
				b10Num.append ("5");
				break;
			case 20:
				b10Num.append ("6");
				break;
			case 21:
				b10Num.append ("7");
				break;
			case 22:
				b10Num.append ("8");
				break;
			default:
				throw new Exception (HercDistributedCounter.class + " - convertToBase10(...): Number " + num
						+ " is invalid for conversion from base 3 to base 10.");
		}

		return b10Num.toString ();
	}

	/**
	 * Returns the current date in a format based upon the number of days which have
	 * elapsed since HERC_DATE_COUNTER_DATE.
	 * 
	 * @return - String representation of day count since HERC_DATE_COUNTER_DATE.
	 * 
	 * @author Kevin Valentine
	 */
	private static String getDateString () {
		Calendar baseDate = Calendar.getInstance (TimeZone.getTimeZone (TIME_ZONE));
		baseDate.set (Integer.parseInt (DATE_COUNTER_BASE_YEAR), Integer.parseInt (DATE_COUNTER_BASE_MONTH) - 1,
				Integer.parseInt (DATE_COUNTER_BASE_DAY) - 1, 0, 0, 0);
		Calendar curDate = Calendar.getInstance (TimeZone.getTimeZone (TIME_ZONE));

		return String.valueOf ((curDate.getTimeInMillis () - baseDate.getTimeInMillis ()) / MILLISECONDS_PER_DAY);
	}

	/**
	 * Returns the current time of day in seconds since midnight.
	 * 
	 * @return String representing seconds since midnight.
	 * 
	 * @author Kevin Valentine
	 */
	private static String getTimeString () {
		Calendar baseDate = Calendar.getInstance (TimeZone.getTimeZone (TIME_ZONE));

		return String.valueOf (((baseDate.get (Calendar.HOUR_OF_DAY) * 3600) + (baseDate.get (Calendar.MINUTE) * 60) + (baseDate
				.get (Calendar.SECOND))));
	}

	/**
	 * 
	 * @author PRC0042
	 * 
	 *         TODO To change the template for this generated type comment go to
	 *         Window - Preferences - Java - Code Style - Code Templates
	 */
	private static class DistributedCounterLock {
		FileChannel channel;
		FileLock lock;

		public DistributedCounterLock (FileChannel channel, FileLock lock) {
			this.channel = channel;
			this.lock = lock;
		}

		public void release () {
			try {
				// Release the lock
				lock.release ();

				// Close the file
				channel.close ();
			}
			catch (IOException e) {
				System.err.println ("Unable to release the lock: " + e.getMessage ());
			}

		}

		public FileChannel getChannel () {
			return channel;
		}

		public FileLock getLock () {
			return lock;
		}
	}

}
