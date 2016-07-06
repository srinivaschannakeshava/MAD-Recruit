package com.mad.recruit.DB;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBconnection {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://mad-recruit.chkaktqoon4c.ap-southeast-1.rds.amazonaws.com/madrecruit";
	// Database credentials
	static final String USER = "Anshuman";
	static final String PASS = "anshuman";
	static Connection conn = null;

	public static Connection getDBConnection() {

		try {
			if (conn != null && !conn.isClosed()) {
				return conn;
			} else {
				// STEP 2: Register JDBC driver
				Class.forName("com.mysql.jdbc.Driver");
				// STEP 3: Open a connection
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
			}

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeConnection() {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
