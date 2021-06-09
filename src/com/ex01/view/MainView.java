package com.ex01.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.ex01.dto.item.Item;
import com.ex01.dto.item.OrderedList;
import com.ex01.dto.member.Member;

public class MainView {
	
	public static void callMainView(ArrayList<Member> memberList, ArrayList<Item> itemList, ArrayList<OrderedList> orderedList) throws IOException {
		BufferedReader br = null;
		String input = "";
		boolean flag = true;
		try {
			while(flag) {
				System.out.print("<System> 현재 회원의 수는 " + memberList.size() + "\n");
				for(int i = 0; i < memberList.size(); i++) {
					System.out.println("<System> " + memberList.get(i));
				}
				System.out.println("");
				System.out.println("1. 회원가입은 1");
				System.out.println("2. 로그인은 2");
				System.out.println("3. 아이디 찾기는 3");
				System.out.println("4. 비밀번호 재설정은 4");
				System.out.println("0. 프로그램 종료는 0 또는 exit를");
				System.out.println("입력 후 Enter키를 눌러주세요.");
				br = new BufferedReader(new InputStreamReader(System.in));
				input = br.readLine();
				
				switch(input) {
				case ("1"): {
					System.out.println("<System> 회원가입을 선택하셨습니다.\n");
					SignView.callSignUpView(memberList, itemList, orderedList);
					break;
				}
				case ("2"): {
					System.out.println("<System> 로그인을 선택하셨습니다.\n");
					SignView.callSignInView(memberList, itemList, orderedList);
					break;
				}
				case ("3"): {
					System.out.println("<System> 아이디 찾기를 선택하셨습니다.\n");
					FindMissingView.missingAccountView(memberList, itemList, orderedList);
					break;
				}
				case ("4"): {
					System.out.println("<System> 비밀번호 재설정을 선택하셨습니다.\n");
					FindMissingView.missingPasswordView(memberList, itemList, orderedList);
					break;
				}
				case ("0"): {
					System.out.println("<System> 0을 입력했습니다.\n<System> 프로그램이 종료됩니다...");
					System.exit(0);
				}
				case ("exit"): {
					System.out.println("<System> exit을 입력했습니다.\n<System> 프로그램이 종료됩니다...");
					System.exit(0);
				}
				default: System.out.println("<System> 유효한 입력이 아닙니다.");
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
