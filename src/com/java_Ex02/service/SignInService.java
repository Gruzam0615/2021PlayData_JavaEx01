package com.java_Ex02.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java_Ex02.dto.Member;
import com.java_Ex02.util.CurrentDate;
import com.java_Ex02.util.DBConnection;
import com.java_Ex02.util.InputString;
import com.java_Ex02.view.AfterSignView;
import com.java_Ex02.view.ExcuteView;

public class SignInService {
	
	public static void signInMethod() {
		Connection conn = null;
		
		String getAccount = null;
		String getName = null;
		String getMobile = null;
		String getAddress = null;
		String getEmail = null;
		String getRank = null;
		int getMileage = 0;
		String getEntryDate = null;
		String getLastDate = null;
		String getModifiedDate = null;
		
		try {
			InputString is = new InputString();
			
			DBConnection dbc = DBConnection.getInstance();
			conn = dbc.getConn();
			PreparedStatement pstmt = null;
			
			boolean flag = true;
			String inputAccount = null;
			String inputPassword = null;
			
			CurrentDate cd = new CurrentDate();
			String tempdate = cd.getCurrentDate();
			
			while(flag) {
				System.out.println("아이디를 입력해주세요.");
				
				if((inputAccount = is.inputString()).isBlank() == true) {
					System.out.println("아이디 항목이 공백입니다.");
					flag = true;
				} else {
					flag = false;
				}
			}
			flag = true;
			while(flag) {
				System.out.println("비밀번호를 입력해주세요.");
				
				if((inputPassword = is.inputString()).isBlank() == true) {
					System.out.println("비밀번호 항목이 공백입니다.");
					flag = true;
				} else {
				flag = false;
				}
			}
//			System.out.println(inputAccount + ", " + inputPassword);
			
			if(conn == null) {
				System.out.println("<SYSTEM> : 외부 데이터 접근에 실패했습니다.");				
			} else {
				String sql01 = "SELECT 1 FROM member02 WHERE memberaccount=? AND memberpassword=?";
				pstmt = conn.prepareStatement(sql01);
				
				pstmt.setString(1, inputAccount);
				pstmt.setString(2, inputPassword);
				
				ResultSet rs = pstmt.executeQuery();
				if(rs.next() == false) {
					System.out.println("로그인 정보가 유효하지 않습니다.");
					System.out.println("메인화면으로 돌아갑니다.");
					ExcuteView ev = new ExcuteView();
					ev.main(null);
				} else {
					rs.close();
					pstmt.close();
					
					String sql02 = "UPDATE member02 SET lastdate=? WHERE memberaccount=?";
					PreparedStatement pstmt02 = conn.prepareStatement(sql02);					
					
					pstmt02.setString(1, tempdate);
					pstmt02.setString(2, inputAccount);
					
					int rs02 = pstmt02.executeUpdate();
					if(rs02 == 1) {
//						System.out.println("Query Update Done!!");
						pstmt02.close();
					} else {
//						System.out.println("Query Update Fail...");
						pstmt02.close();
					}
					
					String sql03 = "SELECT memberaccount, name, mobile, address, email, rank, mileage, entrydate, lastdate, modifieddate FROM member02 WHERE memberaccount=?";
					PreparedStatement pstmt03 = conn.prepareStatement(sql03);					
					pstmt03.setString(1, inputAccount);					
					ResultSet rs03 = pstmt03.executeQuery();
					
					if(rs03.next() == false) {
						System.out.println("<SYSTEM> : rs03 ERROR");
						rs03.close();
						pstmt03.close();
					} else {
						getAccount = rs03.getString(1);
						getName = rs03.getString(2);
						getMobile = rs03.getString(3);
						getAddress = rs03.getString(4);
						getEmail = rs03.getString(5);
						getRank = rs03.getString(6);
						getMileage = Integer.parseInt(rs03.getString(7));
						getEntryDate = rs03.getString(8);
						getLastDate = rs03.getString(9);
						getModifiedDate = rs03.getString(10);
						rs03.close();
						pstmt03.close();
					}
					Member m = new Member(getAccount, getName, getMobile, getAddress, getEmail, getRank, getMileage, getEntryDate, getLastDate, getModifiedDate);
					AfterSignView.afterSignMethod(m);
				}
			}
			
		} catch(Exception e) {
			System.out.println("<ERROR> : Exception_ " + e);
		} finally {
			try {
//				System.out.println(
//					getAccount + ", " +	getName + ", " + getMobile + ", " + getEmail + "\n" +
//					getAddress + ", " + getRank + ", " + getMileage + "\n" +
//					getEntryDate + "\n" +
//					getLastDate + "\n" +
//					getModifiedDate
//				);
				conn.close();
			} catch(Exception e) {
				System.out.println("<ERROR> : Exception_ " + e);
			}
		}
	}
	
}
