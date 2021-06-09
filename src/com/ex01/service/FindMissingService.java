package com.ex01.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.ex01.dto.item.Item;
import com.ex01.dto.item.OrderedList;
import com.ex01.dto.member.Member;
import com.ex01.view.MainView;

public class FindMissingService {
	
	public static void missingAccount(ArrayList<Member> memberList, ArrayList<Item> itemList, ArrayList<OrderedList> orderedList, String memberName, String memberMobile) throws IOException {
		BufferedReader br = null;
		String input = "";
		boolean flag = true;
		
		Member dto = null;
		
		while(flag) {
			for(int i = 0; i < memberList.size(); i++) {
				dto = memberList.get(i);
				if(dto.getMemberName().equals(memberName) && dto.getMemberMobile().equals(memberMobile)) {
					
					System.out.println("<System> 당신의 아이디는 아래와 같습니다.");
					System.out.println(dto.getMemberAccount() + "\n");
					
					System.out.println("<System> Enter를 누르면 메인화면으로 돌아갑니다.");
					br = new BufferedReader(new InputStreamReader(System.in));
					input = br.readLine();
					try {
						if(Integer.parseInt(input) == 13) {
							MainView.callMainView(memberList, itemList, orderedList);
						}
					} catch(IOException e) {
						if(Integer.parseInt(input) != 13) {
							System.out.println("<System> 올바르지 않은 입력입니다.");
						}
					}
				}
			}
		}
		
	}	
	
	public static void missingPassword(ArrayList<Member> memberList, ArrayList<Item> itemList, ArrayList<OrderedList> orderedList, String memberAccount, String memberName, String memberMobile) {
		BufferedReader br = null;
		String input = null;
		boolean flag = true;
		
		Member dto = null;		
		
			while(flag) {
				for(int i = 0; i < memberList.size(); i++) {
					dto = memberList.get(i);
					if(dto.getMemberAccount().equals(memberAccount) && 
						dto.getMemberName().equals(memberName) && 
						 dto.getMemberMobile().equals(memberMobile)) {
						
						System.out.println("<System> 새로운 비밀번호를 입력해주세요.");
						
						br = new BufferedReader(new InputStreamReader(System.in));
						try {
							input = br.readLine();
						} catch (IOException e) {
							if(input.isBlank()) {
								System.out.println("<System> 새로운 비밀번호를 입력해 주세요.");
							}
						}
					
						String newPassword = input.trim();
						dto.setMemberPassword(newPassword);
						System.out.println("<System> 비밀번호가 성공적으로 변경되었습니다. 메인메뉴로 이동합니다.\n");
						
						flag = false;
					}
				}				
			}
		
		
	}
	
	public static void print(String input) {		
		System.out.printf("<System> you entered: %s \n", input);
	}

	
}
