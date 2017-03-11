package com.hertz.herc.franchise.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URL;

public class JVFile {
	private static final int DATA_BLOCK_SIZE = 1024;

	public static String readFileFromWebAppClasspath (Class<?> classRef, String path) {
//		System.out.println ("--- JVFile::readFileFromWebAppClasspath; path " + path);
		final char[] buffer = new char[DATA_BLOCK_SIZE];
		final StringBuilder out = new StringBuilder ();
		InputStream is = null;
		Reader in = null;
		try {
			is = classRef.getClassLoader ().getResourceAsStream (path);
			in = new InputStreamReader (is, "UTF-8");
			for (;;) {
				int rsz = in.read (buffer, 0, buffer.length);
				if (rsz < 0) break;
				out.append (buffer, 0, rsz);
			}
			return out.toString ();
		}
		catch (Exception ex) {
			System.out.println ("Exception; " + ex.getMessage ());
		}
		finally {
			try {
				if (is != null) is.close();
				if (in != null) in.close ();
			}
			catch (Exception e) {}
		}
		return null;
	}

	public static StringBuffer readFileFromClasspath (Class<?> classRef, String path) {
//		System.out.println ("--- JVFile::readFileFromClasspath; path " + path);
		try {
			URL url = classRef.getClass ().getResource (path);
//			System.out.println ("url " + url.getPath ());
			File file = new File (url.toURI ());
			return readFile (file.getPath ());
		}
		catch (Exception ex) {
			System.out.println ("Exception; " + ex.getMessage ());
		}
		return null;
	}

	public static StringBuffer readFile (String fileName) {
		File file = new File (fileName);
		StringBuffer sb = new StringBuffer ();

		try {
			if (!file.exists ()) return null;

			BufferedReader br = new BufferedReader (new FileReader (file));
			try {
				String lineSep = "\n";
				String nextLine;
				while ((nextLine = br.readLine ()) != null) {
					sb.append (nextLine);
					sb.append (lineSep);
				}
			}
			finally {
				br.close ();
			}
		}
		catch (IOException ioe) {
			return null;
		}
		return sb;
	}

	public static boolean copyFile (String strFromFile, String strToFile) {
		// System.out.println("Copying file "+strFromFile+" to file "+strToFile);
		int byteCount;
		try {
			FileInputStream fis = new FileInputStream (strFromFile);
			BufferedInputStream bufIn = new BufferedInputStream (fis, DATA_BLOCK_SIZE);

			FileOutputStream fos = new FileOutputStream (strToFile);
			BufferedOutputStream bufOut = new BufferedOutputStream (fos, DATA_BLOCK_SIZE);

			byte[] data = new byte[1024];
			while ((byteCount = bufIn.read (data, 0, DATA_BLOCK_SIZE)) != -1) {
				bufOut.write (data, 0, byteCount);
			}
			bufIn.close ();
			bufOut.flush ();
			bufOut.close ();
		}
		catch (IOException ex) {
			// System.out.println("Unable to copy the file; "+ex.getMessage());
			return false;
		}
		return true;
	}

	public static boolean writeFile (String strText, String strFile) {
		return writeFile (strText, new File (strFile));
	}

	public static boolean writeFile (String strText, File file) {
		try {
			PrintWriter pw = new PrintWriter (new BufferedWriter (new FileWriter (file)));
			pw.print (strText);
			pw.flush ();
			pw.close ();
			return true;
		}
		catch (IOException ex) {
			// System.out.println("Unable to write the file; "+ex.getMessage());
			return false;
		}
	}

	public static void removeFile (String strFile) {
		removeFile (new File (strFile));
	}

	public static void removeFile (File file) {
		// System.out.println("Removing file "+file.getPath());
		if (file.isFile ()) file.delete ();
	}

	public static String getName (String strName) {
		if (strName == null || strName.length () < 1) return "";
		int pos = strName.lastIndexOf ('.');
		if (pos < 0) return strName;
		return strName.substring (0, pos);
	}

	public static String getExtension (String strName) {
		if (strName == null || strName.length () < 1) return "";
		int pos = strName.lastIndexOf ('.');
		if (pos < 0) return "";
		return strName.substring (pos + 1);
	}

	public static boolean makeDirectories (File file) {
		// System.out.println("--- JVFile::makeDirectories; file :"+file.getPath()+":");
		file = new File (file.getPath ());
		return file.getParentFile ().mkdirs ();
		// System.out.println("<<< makeDirectories; bool "+bool);
	}

	public static boolean makeFullDirectories (File file) {
		// System.out.println("--- JVFile::makeFullDirectories; file :"+file.getPath()+":");
		file = new File (file.getPath ());
		return file.mkdirs ();
		// System.out.println("<<< makeDirectories; bool "+bool);
	}

	public static File makeWorkingDirectory (File file) {
		String tmpDir = Long.toString (System.currentTimeMillis ());
		return new File (file.getPath () + File.separatorChar + tmpDir);
	}

	public static File makeWorkingFile (File baseDirectory) {
		String tmpFile = Long.toString (System.currentTimeMillis ());
		return new File (baseDirectory.getPath () + File.separatorChar + tmpFile + ".txt");
	}
}
