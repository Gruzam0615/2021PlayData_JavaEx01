package com.java_Ex02.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class DBConnection {
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:ORCLCDB";
	private static OracleDataSource ods = null;
	private static Connection conn = null;
	
	public Connection getConn() {
		return conn;
	}
	
	private static DBConnection instance = new DBConnection();	
	
	private DBConnection() {
		try {
			ods = new OracleDataSource();
			ods.setUser("tester02");
			ods.setPassword("1234");
			ods.setURL(url);
			conn = ods.getConnection();
			conn.setAutoCommit(true); //Auto Commit Setting
			
			if(conn == null) {
				System.out.println("<SYSTEM> : DB Connection Failed...");
			} else {
//				System.out.println("<SYSTEM> : DB Connection Succeed!!!");
			}
		} catch(SQLException e) {
			System.out.println("<ERROR> : 유효하지 않은 DB연결 처리입니다. " + e);
		} catch(Exception e) {
			System.out.println("<ERROR> : " + e);
		}
		
	}
	
	public static DBConnection getInstance() {
		return instance;
	}	
	
}
