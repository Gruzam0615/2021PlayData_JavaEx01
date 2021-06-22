package com.java_Ex02.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.java_Ex02.dto.Member;
import com.java_Ex02.util.CheckValidity;
import com.java_Ex02.util.DBConnection;
import com.java_Ex02.util.InputString;
import com.java_Ex02.view.ExcuteView;

public class SignUpService {
	InputString is = new InputString();	

	public void signUpMethod() {
		Member m = null;
		boolean answer = false;
		
		String memberaccount = null;
		String memberpassword = null;
		String membername = null;
		String membermobile = null;
		String memberaddress = null;
		String memberemail = null;
		String memberrank = null;
		
		try {
			CheckValidity cv = new CheckValidity();
			System.out.println("회원가입을 시작합니다.");		
			
			boolean flag = true;
			while(flag) {
				System.out.println("ID를 입력해주세요. 6~15 자리의 영어소문자만 사용 가능합니다.");
				memberaccount = is.inputString();
				if(cv.checkAccount(memberaccount)) {
					flag = false;
				} else {
					flag = true;
				}
			}
			
			boolean flag2 = true;
			while(flag2) {
				System.out.println("ID의 비밀번호를 입력해주세요. 8~20 자리로 영어 대소문자와 숫자만 사용 가능합니다.");
				memberpassword = is.inputString();
				if(cv.checkPassword(memberpassword)) {
					flag2 = false;
				} else {
					flag2 = true;
				}
			}			
			
			boolean flag3 = true;
			while(flag3) {
				System.out.println("사용자의 이름을 입력해주세요.");
				membername = is.inputString();
				if(membername.isBlank()) {
					System.out.println("<SYSTEM> : 이름항목이 공백입니다.");
					flag3 = true;
				} else {
					System.out.println("이름이 입력되었습니다.");
					flag3 = false;
				}
			}
			
			boolean flag4 = true;
			while(flag4) {
				System.out.println("사용자의 핸드폰 번호를 입력해주세요.");
				System.out.println("핸드폰 번호는 숫자만 입력해주세요. 붙임표(-)는 입력하지 않습니다.");
				membermobile = is.inputString();
				if(cv.checkMobile(membermobile)) {
					flag4 = false;
				} else {
					flag = true;
				}
			}
			
			flag = true;
			while(flag) {
				System.out.println("사용자의 주소를 입력해주세요.");
				memberaddress = is.inputString();
				if(memberaddress.length() > 50) {
					System.out.println("<SYSTEM> : 주소를 다시 입력해주세요.");
					flag = true;
				} else {
					System.out.println("주소가 입력되었습니다. ");
					flag = false;
				}
			}
			
			flag = true;
			while(flag) {
				System.out.println("사용자의 이메일 주소를 입력해주세요.");
				memberemail = is.inputString();
				if(cv.checkEmail(memberemail)) {
					flag = false;
				} else {
					flag = true;
				}
			}
			
			flag = true;
			while(flag) {
				System.out.println("일반 회원은 g, 판매자 회원은 p 를 입력해주세요.");
				memberrank = is.inputString();
				if(memberrank.equals("g")) {
					System.out.println("일반 회원을 선택하셨습니다.");
					flag = false;
				} else if(memberrank.equals("p")) {
					System.out.println("판매자 회원을 선택하셨습니다.");
					flag = false;
				} else {
					System.out.println("잘못된 입력입니다.");
					System.out.println("일반 회원은 g, 판매자 회원은 p 를 입력해주세요.");
					flag = true;
				}
			}
			
		} catch(Exception e) {
			System.out.println("<ERROR> : 예상외의 에러입니다. " + e);
		} finally {
			m = new Member(memberaccount, memberpassword, membername, membermobile, memberaddress, memberemail, memberrank);
			String entrydate = m.getEntryDate();
			String lastDate = m.getLastDate();
			String modifiedDate = m.getModifiedDate();
			
			DBConnection dbc = DBConnection.getInstance();
			Connection conn = dbc.getConn();
			PreparedStatement pstmt = null;
			
			if(m != null) {
				try {
					String sql01 = "INSERT INTO member02(memberaccount, memberpassword, name, mobile, address, email, rank, mileage, entrydate, lastdate, modifieddate ) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					pstmt =  conn.prepareStatement(sql01);
					pstmt.setString(1, memberaccount);
					pstmt.setString(2, memberpassword);
					pstmt.setString(3, membername);
					pstmt.setString(4, membermobile);
					pstmt.setString(5, memberaddress);
					pstmt.setString(6, memberemail);
					pstmt.setString(7, memberrank);
					pstmt.setInt(8, 1000);
					pstmt.setString(9, entrydate);
					pstmt.setString(10, lastDate);
					pstmt.setString(11, modifiedDate);
					
					int result = pstmt.executeUpdate();
					
					if(result != 0) {
						System.out.println("회원가입이 완료되었습니다.");
						answer = true;
					}
					
				} catch(SQLException e) {
					System.out.println("<ERROR> : SQLException_ " + e);
					System.out.println("<ERROR> : 회원가입에 실패했습니다.");
				} catch(Exception e) {
					System.out.println("<ERROR> : SQL_INSERT_" + e);
					System.out.println("<ERROR> : 회원가입에 실패했습니다.");
				} finally {
					try {
					pstmt.close();
					conn.close();
					} catch(Exception e) {
						System.out.println("<ERROR> : Close_" + e + "\n");
					}
				}
			}
		}
			System.out.println("신규회원: ");
			System.out.println(m.toString());
			
//			return answer;
	}
	
}
