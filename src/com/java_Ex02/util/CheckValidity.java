package com.java_Ex02.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CheckValidity {
	
	public static void main(String[] args) {
//		checkAccount("admin00");
//		checkAccount("gruzam0615");		
//		checkAccount("그루잠0615");
//		checkAccount("short");
//		checkAccount("veryveryverylong");
		
//		checkPassword("1234");
//		checkPassword("123412341234123412341234");
//		System.out.println();
//		checkPassword("1234123412341234");	
//		checkPassword("password0012");
//		System.out.println();
//		checkPassword("!!password0011");
//		checkPassword("password00!!");
//		checkPassword("password00--");
//		checkPassword("--aa--password)");
		
//		checkMobile("01050435150");
//		checkMobile("010-5043-5150");
//		checkMobile("0101231234");
//		checkMobile("12341234");
//		checkMobile("0101234123");
//		checkMobile(" ");
//		checkMobile("");
		
//		checkEmail("gruzam0615@gmail.com");
//		checkEmail("gruzam0615@gamil.co.kr");
//		checkEmail("");
//		checkEmail("1234co.kr");
	}	
	/**
	 * <pre>
	 * 아이디 검증
	 * </pre>
	 * @param ia
	 * @return boolean
	 */
	public boolean checkAccount(String ia) {
		boolean answer = false;
		String regExp = "^[a-z0-9]*$";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		if(ia.length() < 6) {
			System.out.printf("%s는 사용 불가능한 ID입니다. ID의 길이가 너무 짧습니다. 6자 이상으로 작성해주세요.\n", ia);
			answer = false;
		} else if(ia.length() > 15) {
			System.out.printf("%s는 사용 불가능한 ID입니다. ID의 길이가 너무 깁니다. 15자 이하로 작성해주세요.\n", ia);
			answer = false;
		} else if(ia.length() >= 6 && ia.length() <= 15) {
			if(!ia.matches(regExp)) {				
				System.out.printf("%s는 사용 불가능한 ID입니다. ID는 영어소문자로만 작성해주세요.\n", ia);
				answer = false;
			} else {
				DBConnection dbc = DBConnection.getInstance();
				Connection conn = dbc.getConn();
				if(conn == null) {
					System.out.println("<SYSTEM> : 외부 데이터를 불러오는데 실패했습니다.");
				} else {					
					try {
						String sql01 = "SELECT 1 FROM member02 WHERE memberaccount=?";
						pstmt = conn.prepareStatement(sql01);						
						pstmt.setString(1, ia);
						
						rs = pstmt.executeQuery();
						
						if(rs.next() != false) {
							System.out.printf("%s는 이미 존재하는 ID입니다.\n", ia);
							answer = false;
						}else {
							System.out.printf("%s는 사용가능한 ID입니다. \n", ia);
							answer = true;
						}
						
					}catch(Exception e) {
						System.out.println("<SYSTEM> : 외부 데이터를 불러오는데 실패했습니다.\n" + e);
					}					
				}
			}
		}
		return answer;
	}
	
	/**
	 * <pre>
	 * 비밀번호 검증
	 * </pre>
	 * @param input
	 * @return boolean
	 */
	public boolean checkPassword(String input) {
		boolean answer = false;
		//String regExp = "^.*(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*()]).*$";
		String regExp = "^[A-Za-z0-9]*$";
		
		if(input.length() < 8) {
			System.out.println("비밀번호가 너무 짧습니다. 비밀번호는 최소 8자 이상으로 설정해주세요.");
			answer = false;
		} else if(input.length() > 20) {
			System.out.println("비밀번호가 너무 깁니다. 비밀번호는 20자 이하로 설정해주세요.");
			answer = false;
		} else if(input.length() >= 8 && input.length() <= 20 ) {
			if(!input.matches(regExp)) {
				System.out.println("사용할수 없는 비밀번호입니다 비밀번호는 영어 대소문자, 숫자로만 설정 가능합니다.");
				answer = false;
			} else {
				System.out.println("입력한 비밀번호는 적합한 비밀번호 입니다.");
				answer = true;
			}
		}
		
		return answer;
	}
	/**
	 * <pre>
	 * 핸드폰 번호 검증
	 * </pre>
	 * @param input
	 * @return boolean
	 */
	public boolean checkMobile(String input) {
		boolean answer = false;
		String regExp = "^\\d{3}\\d{3,4}\\d{4}$";
		
		if(!input.matches(regExp)) {
			System.out.println("<SYSTEM> : 잘못된 입력입니다. 붙임표(-)를 제외하고 숫자만 입력하세요.");
			answer = false;
		} else {
			System.out.println("사용가능한 휴대폰 번호입니다.");
			answer = true;
		}		
		return answer;
	}
	/**
	 * <pre>
	 * email 검증
	 * </pre>
	 * @param input
	 * @return boolean
	 */
	public boolean checkEmail(String input) {
		boolean answer = false;
		String regExp = "^[_a-z0-9-]+(.[_a-z0-9]+)*@(?:\\w+\\.)+\\w+$";
		
		if(!input.matches(regExp)) {
			System.out.println("<SYSTEM> : 잘못된 이메일 주소입니다.");
			answer = false;
		} else {
			System.out.println("사용가능한 이메일 주소입니다.");
			answer = true;
		}		
		return answer;
	}

	
}
