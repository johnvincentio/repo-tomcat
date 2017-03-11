package com.idc.pool.mysql3;

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

@WebServlet("/List2")
public class List2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/hesDB")
	private DataSource dataSource;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		try {
			Connection conn = dataSource.getConnection();

			Statement statement = conn.createStatement();
			String sql = "select id, branch from hes_locations";
			ResultSet rs = statement.executeQuery(sql);

			int count = 1;

			while (rs.next()) {
                writer.println(String.format("List2: count #%d: %d %s", count++, rs.getLong("id"), rs.getString("branch")));
			}
		} catch (SQLException ex) {
			System.err.println(ex);
		}
	}

}
