package com.idc.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class D1
 */
@WebServlet("/D1")
public class D1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="jdbc/mydb2")
	private DataSource ds;

    public D1() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doTest (request, response);
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<h1>Hello D1!</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
	}
	private boolean doTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>> doTest - D1 - 2");
		try {
			doConnect (ds);
		}
		catch (Exception ex) {
			System.out.println("Error; "+ex.getMessage());
		}

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
