package com.idc.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/C1")
public class C1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public C1() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doTest(request, response);
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<h1>Hello C1!</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
	}
	private boolean doTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>> doTest - C1 - 1");
		try {
			Context initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup ("java:/comp/env/jdbc/mydb2");
			doConnect (ds);
		}
		catch (Exception ex) {
			System.out.println("Error; "+ex.getMessage());
		}

//		doConnect ("jdbc:db2://db2dev.dev.irac.ecom.ad.hertz.com:60100/ecomdev");
		System.out.println("<<< doTest");
		return true;
	}

	private void doConnect (DataSource ds) {
		System.out.println(">>> doConnect");
		Connection connection;
		try {
			connection = ds.getConnection();
			String selectTableSQL = "SELECT memberid, username from HERCDB.MEMBERS";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(selectTableSQL);
			while (rs.next()) {
				String userid = rs.getString("MEMBERID");
				String username = rs.getString("USERNAME");
				System.out.println("userid :" + userid + ": username :" + username + ":");
			}
			System.out.println("<<< doConnect");
		}
		catch (SQLException ex) {
			System.out.println("Exception; " + ex.getMessage());
			System.out.println("could not get connection");
		}
	}
}

