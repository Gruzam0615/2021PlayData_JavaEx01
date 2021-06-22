package com.java_Ex02.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.pool.OracleDataSource;

public class DBTest {

	public static void main(String[] args) {
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:ORCLCDB";
			OracleDataSource ods = null;
			Connection conn = null;
			
			ods = new OracleDataSource();
			ods.setUser("tester02");
			ods.setPassword("1234");
			ods.setURL(url);
			conn = ods.getConnection();			

			if(conn == null) {
				System.out.println("<SYSTEM> : DB Connection Failed...");
			} else {
				System.out.println("<SYSTEM> : DB Connection Succeed!!!");
				System.out.println("SEARCHING....");
				PreparedStatement pstmt = null;
				Statement stmt = null;
				ResultSet rs = null;
				
				String sql = "SELECT 1 FROM member02 WHERE memberaccount=?";
				
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "admin00");
					
					stmt = conn.createStatement();					
					
					rs = pstmt.executeQuery();
					
									
					if(rs.next()) {
						System.out.println(rs.toString());
					}
					
				} catch(SQLException e) {
					System.out.println("<SYSTEM> SQLException : " + e + "\n");
					throw new Exception(e);
				} catch(Exception e) {
					System.out.println("<SYSTEM> EXCEPTION : " + e + "\n");
				}
				
			}
			
			
		} catch(Exception e) {
			System.out.println("<ERROR> : " + e + "\n");
		}
	}

}
