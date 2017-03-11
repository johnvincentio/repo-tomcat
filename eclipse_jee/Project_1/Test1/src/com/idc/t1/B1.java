package com.idc.t1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class B1 {
	private static final String USERNAME = "prc4031";
	private static final String PASSWORD = "love257$";

	public static void main (String[] args) {
		(new B1()).doTest();
	}

	private boolean doTest () {
		System.out.println(">>> doTest - 1");
		String dbdriver = "com.ibm.db2.jcc.DB2Driver";
		try {
			DriverManager.registerDriver((Driver)Class.forName(dbdriver).newInstance());
			System.out.println("driver registered");
		} 
		catch (Exception e) {
			System.out.println("Error; unable to register the driver "+e.getMessage());
//			return false;
		}
		doConnect ("jdbc:db2://db2dev.dev.irac.ecom.ad.hertz.com:60100/ecomdev");
		System.out.println("<<< doTest");
		return true;
	}
	private void doConnect (String url) {
		System.out.println(">>> doConnect; url :"+url+":");
		Connection connection;
		try {
		 	connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
			String selectTableSQL = "SELECT memberid, username from HERCDB.MEMBERS";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(selectTableSQL);
			while (rs.next()) {
				String userid = rs.getString("MEMBERID");
				String username = rs.getString("USERNAME");
				System.out.println("userid :"+userid+": username :"+username+":");
			}
		 	System.out.println("<<< doConnect; url :"+url+":");
		}
		catch (SQLException ex) {
			System.out.println("Exception; "+ex.getMessage());
			System.out.println("could not get connection for url :"+url+":");
		}
	}
}
