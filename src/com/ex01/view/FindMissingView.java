package com.ex01.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.ex01.dto.item.Item;
import com.ex01.dto.item.OrderedList;
import com.ex01.dto.member.Member;
import com.ex01.service.FindMissingService;

public class FindMissingView {
	public static void missingAccountView(ArrayList<Member> memberList, ArrayList<Item> itemList, ArrayList<OrderedList> orderedList) {
		BufferedReader br = null;
		String input = "";
		
		boolean flag = true;
		
		try {
			while(flag) {
				String[] tempInput = new String[2];
				
				System.out.print("<System> 아래의 형식에 맞춰 회원정보를 입력해주세요.\n");
				System.out.println("사용자 이름, 휴대전화 번호");
				
				br = new BufferedReader(new InputStreamReader(System.in));
				input = br.readLine();
				String[] splitInput = input.split(",");
				for(int i = 0; i < tempInput.length; i++) {
					tempInput[i] = splitInput[i].trim();
				}
				FindMissingService.missingAccount(memberList, itemList, orderedList, tempInput[0], tempInput[1]);
//				br.skip(0);
				flag = false;
			}
		}catch(Exception e) {
			System.out.println("<Error> " + e + "\n");
		}		
	}

	public static void missingPasswordView(ArrayList<Member> memberList, ArrayList<Item> itemList, ArrayList<OrderedList> orderedList) {
		BufferedReader br = null;
		String input = "";
		boolean flag = true;
		try {
			while(flag) {
				String[] tempInput = new String[3];
				
				System.out.print("<System> 아래의 형식에 맞춰 회원정보를 입력해주세요.\n");
				System.out.println("아이디, 이름, 휴대전화 번호");
				
				br = new BufferedReader(new InputStreamReader(System.in));
				input = br.readLine();
				String[] splitInput = input.split(",");
				for(int i = 0; i < tempInput.length; i++) {
					tempInput[i] = splitInput[i].trim();
				}
				FindMissingService.missingPassword(memberList, itemList, orderedList, tempInput[0], tempInput[1], tempInput[2]);
				br.skip(0);
				flag = false;
			}
		} catch(Exception e) {
			System.out.println("<ERROR> " + e + "\n");
		}
	}
	
	
}
