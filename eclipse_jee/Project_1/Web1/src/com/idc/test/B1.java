package com.idc.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class B1
 */
@WebServlet("/B1")
public class B1 extends HttpServlet {
	private static final String USERNAME = "prc4031";
	private static final String PASSWORD = "love257$";

	private static final long serialVersionUID = 1L;

    public B1() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doTest(request, response);
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<h1>Hello B1!</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
	}
	private boolean doTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>> doTest - 4");
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

	private void doConnect(String url) {
		System.out.println(">>> doConnect; url :" + url + ":");
		Connection connection;
		try {
			connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
			String selectTableSQL = "SELECT memberid, username from HERCDB.MEMBERS";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(selectTableSQL);
			while (rs.next()) {
				String userid = rs.getString("MEMBERID");
				String username = rs.getString("USERNAME");
				System.out.println("userid :" + userid + ": username :" + username + ":");
			}
			System.out.println("<<< doConnect; url :" + url + ":");
		}
		catch (SQLException ex) {
			System.out.println("Exception; " + ex.getMessage());
			System.out.println("could not get connection for url :" + url + ":");
		}
	}
}
