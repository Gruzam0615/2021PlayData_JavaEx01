package com.ex01.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.ex01.dto.item.Item;
import com.ex01.dto.member.Member;

public class ItemService {

	public static void addItem(ArrayList<Member> memberList, ArrayList<Item> itemList, Member m) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] splitInput = new String[6];
			
			System.out.println("<System> 판매할 상품을 등록합니다. 아래에 양식을 따라 판매 상품 정보를 입력해주세요.");
			System.out.println("상품 이름, 상품 브랜드, 상품 대분류, 상품 가격, 상품 재고 수");
			
			String input = br.readLine();
			String[] tempInput = input.split(",");
			
			for(int i = 0; i < splitInput.length-1; i++) {
				if(tempInput[i] != "") {
					splitInput[i] = tempInput[i].trim().toLowerCase();
				} else {
					System.out.println("<ERROR> 잘못된 입력입니다. 이전화면으로 돌아갑니다.\n");
					break;
				}
				
			}
			splitInput[5] = m.getMemberAccount();
			Item dto = new Item((itemList.size()+1), splitInput[0], splitInput[1], splitInput[2], Integer.parseInt(splitInput[3]), Integer.parseInt(splitInput[4]), splitInput[5]);
			itemList.add(dto);
			System.out.println("<System> 상품 등록이 완료되었습니다.");
			
		} catch(Exception e) {
			System.out.println("<ERROR> " + e + "\n");
		}
		
	}

}
