package com.java_Ex02.view;

import java.sql.Connection;
import java.sql.SQLException;

import com.java_Ex02.dto.Member;
import com.java_Ex02.util.CurrentDate;
import com.java_Ex02.util.DBConnection;

public class AfterSignView {

	public static void afterSignMethod(Member m) {
		System.out.println("로그인이 완료 되었습니다.");
		System.out.println(m.getMemberAccount() + " 님 환영합니다.");		
		
	}
	
}
