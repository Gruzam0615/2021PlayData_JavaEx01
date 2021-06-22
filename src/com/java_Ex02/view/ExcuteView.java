package com.java_Ex02.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExcuteView {

	public static void main(String[] args) {
		System.out.print("방문을 환영합니다.\n");
		try {
			System.out.println("회원가입은 1");
			System.out.println("로그인은 2");
			System.out.println("종료는 0 or exit");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input = br.readLine();
			
			switch(input) {
			case("1") : {
				System.out.println("1을 입력하셨습니다.");
				SignView sv = new SignView();
				sv.signUp();
				break;
			}
			case("2") : {
				System.out.println("2를 입력하셨습니다.");
				SignView sv = new SignView();
				sv.signIn();
				break;
			}
			case("0") : {
				System.out.printf("%s를 입력하셨습니다.", input);
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
			case("exit") : {
				System.out.printf("%s를 입력하셨습니다.", input);
				System.out.println("프로그램을 종료합니다.");
				System.exit(0); 
			}
			default : {
				System.out.printf("%s는 유효하지 않은 입력입니다.\n", input);
				main(args);
			}
			}
			
		} catch(IOException e) {
			System.out.println("<ERROR> : 유효하지 않은 입력입니다. " + e);
		} catch(Exception e) {
			System.out.println("<ERROR> : 유효하지 않은 입력입니다. " + e);
		}
	}

}
