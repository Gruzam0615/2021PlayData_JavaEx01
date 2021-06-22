package com.java_Ex02.view;

import com.java_Ex02.service.SignInService;
import com.java_Ex02.service.SignUpService;

public class SignView {	
	
	public void signUp() {
		System.out.println("회원가입을 합니다.");
		SignUpService sus = new SignUpService();
		sus.signUpMethod();
		
		ExcuteView ev = new ExcuteView();
		ev.main(null);
	}	
	
	public static void signIn() {
		System.out.println("로그인을 합니다.");
		SignInService.signInMethod();		
	}
	
}

