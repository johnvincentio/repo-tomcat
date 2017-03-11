package com.hertz.herc.franchise.util;

import java.util.Random;

public class RandomHelper {

	/**
	 * Generates a unique number with a base including the IP Address of the
	 * server to ensure uniqueness across multiple concurrent instances.
	 * 
	 * @param ipAddress - 4 octet IP address to ensure uniqueness across multiple instances.
	 * @return - String containing a unique number.
	 * @throws HertzSystemException
	 * 
	 * @author Kevin Valentine
	 */
	public static long getUniqueNumberForIP (String ipAddress) throws Exception {
		try {
			return Long.getLong (HercDistributedCounter.getUniqueNumberForIP (ipAddress)).longValue ();
		}
		catch (Exception ex) {
			throw new Exception (ex.getMessage ());
		}
	}

	/**
	 * Generates a unique number with a base including the IP Address of the
	 * server to ensure uniqueness across multiple concurrent instances.
	 * IP address is retrieved from the local system.
	 * 
	 * @return - String containing a unique number.
	 * @throws HertzSystemException
	 * 
	 * @author Kevin Valentine
	 */
	public static long getUniqueNumber () throws Exception {
		try {
			return Long.parseLong (HercDistributedCounter.getUniqueNumber ());
		}
		catch (Exception ex) {
			throw new Exception (ex.getMessage ());
		}
	}

	/**
	 * Generates a unique number.
	 * 
	 * @author John Vincent
	 * @return the unique number as a String
	 */
	public static String getUniqueString () throws Exception {
		try {
			return HercDistributedCounter.getUniqueNumber ();
		}
		catch (Exception ex) {
			throw new Exception (ex.getMessage ());
		}
	}

	/**
	 * Create a temporary password.
	 * 
	 * @author John Vincent
	 * @return a temporary password
	 */
	public static String createTemporaryPassword () {
		return createFriendlyRandomString ();
	}

	/**
	 * Create an invite member key.
	 * 
	 * @author John Vincent
	 * @return an invite member key
	 */
	public static String createInviteKey () {
		return createFriendlyRandomString ();
	}

	/**
	 * Creates a more user friendly (easier to remember and type in) random string
	 * 
	 * @auther Michael Tardif
	 * @return random string of 3 letters, 3 numbers
	 */
	public static String createFriendlyRandomString () {
		StringBuffer buffer = new StringBuffer ();
		Random rand = new Random ();
		for (int i = 0; i < 3; i++)
			buffer.append ((char) ('a' + rand.nextInt (26)));
		for (int i = 0; i < 3; i++)
			buffer.append (rand.nextInt (10));
		return buffer.toString ();
	}

	/**
	 * Generates junk text for testing
	 * 
	 * @return Random String
	 */
	public static String r () {
		int num = (int) (Math.random () * 10 + 2);
		String s = "";
		for (int i = 0; i < num; i++) {
			if ((((int) (Math.random () * 10)) % 2) != 0)
				s += new Character ((char) (Math.random () * 100 % 26 + 65)).toString ();
			else
				s += new Character ((char) (Math.random () * 100 % 26 + 97)).toString ();
		}
		return s;
	}

	/**
	 * Mangle a String to make it unrecognizable
	 * 
	 * @param srcData String to mangle
	 * @return Mangled String
	 */
	public static String mangleString (String srcData) {
		String mangledString = "";
		int[] roll = {1, 27, 34, 7, 12, 64, 2, 17, 4, 7, 23, 87, 10, 2, 3, 15, 77, 43, 59, 40};
		int rLen = roll.length;
		int t_int;
		char c;
		Random rand = new Random ();

		for (int i = 0; i < srcData.length (); i++) {
			c = srcData.charAt (i);
			if (c >= 97 && c <= 122) // ASCII lowercase character, mutate to another lowercase character.
				mangledString += (char) (((srcData.charAt (i) + rand.nextInt (rLen)) % 26) + 97);
			else if (c >= 65 && c <= 90) // ASCII uppercase character, mutate to another uppercase character.
				mangledString += (char) (((srcData.charAt (i) + rand.nextInt (rLen)) % 26) + 65);
			else if (c >= 48 && c <= 57) { // ASCII Digit, mutate to another digit
				t_int = c;
				while (t_int == c) {
					t_int = rand.nextInt (10);
				}
				mangledString += t_int;
			}
			else
				mangledString += c;
		}
		return mangledString;
	}

	/**
	 * Generate a random number in a given range.
	 * 
	 * @author John Vincent
	 * @param from bottom of the range
	 * @param to top of the range
	 * @return random number
	 */
	public static int getRandom (int from, int to) throws Exception {
		if (from >= to) throw new Exception ("RandomHelper.getRandom; from " + from + " must be less than to " + to);
		Random random = new Random ();
		return random.nextInt ((to + 1) - from) + from;
	}

	/**
	 * Generate a random string.
	 * 
	 * @author John Vincent
	 * @param length length of the string
	 * @return random string
	 */
	public static StringBuffer generateRandomString (int length) throws Exception {
		if (length < 1) throw new Exception ("RandomHelper.generateRandomString; length " + length + " must be great than 0");
		char[] values = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
				'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
				'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		StringBuffer buf = new StringBuffer ();
		Random random = new Random ();
		for (int i = 0; i < length; i++) {
			int idx = random.nextInt (values.length);
			buf.append (values[idx]);
		}
		return buf;
	}

	/**
	 * Convert Long to a Unique String
	 * 
	 * @param number Long number
	 * @return Unique String
	 */
	public static String getUniqueStringFromLong (long number) {
		char[] b64e = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
				'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

		StringBuffer cbuf = new StringBuffer ();
		long m1 = Math.abs (number);
		long quotient = 1, remainder = 1;
		do {
			quotient = m1 / 36;
			remainder = m1 % 36;
			cbuf.append (b64e[(int) remainder]);
			m1 = quotient;
		} while (quotient > 1);
		return cbuf.toString ();
	}
}
