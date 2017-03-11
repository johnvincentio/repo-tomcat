package com.idc.pool.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
	public static void main(String[] args) {
		doTest();
	}
	private static void doTest() {
		String dbUrl = "jdbc:mysql://localhost/hes_db";
	    String dbClass = "com.mysql.jdbc.Driver";
	    String query = "Select distinct(table_name) from INFORMATION_SCHEMA.TABLES";
	    String username = "hes";
	    String password = "hes";
	    try {

	        Class.forName(dbClass);
	        Connection connection = DriverManager.getConnection(dbUrl, username, password);
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery(query);
	        while (resultSet.next()) {
	        String tableName = resultSet.getString(1);
	        System.out.println("Table name : " + tableName);
	        }
	        connection.close();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
