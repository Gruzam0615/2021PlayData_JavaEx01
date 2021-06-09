package com.ex01.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.ex01.dto.item.Item;
import com.ex01.dto.item.OrderedList;
import com.ex01.dto.member.Member;
import com.ex01.service.OrderItemService;

public class OrderItemView {

	public static void callOrderItem(ArrayList<Member> memberList, ArrayList<Item> itemList, ArrayList<OrderedList> orderedList, Member m) {
		System.out.println("<System> 상품을 주문합니다. 아래의 양식에 맞춰 구매신청서를 작성해주세요.");
		System.out.println("상품번호, 구매수량");
		
		BufferedReader br = null;
		String input = null;
		
		br = new BufferedReader(new InputStreamReader(System.in));
			String[] tempInput = new String[2];
			try {
				input = br.readLine();
				String[] splitInput = input.split(",");
				for(int i = 0; i < tempInput.length; i++) {
					tempInput[i] = splitInput[i].trim();
				}
				OrderItemService.callOrderService(memberList, itemList, orderedList, tempInput[0], tempInput[1], m);
			} catch (IOException e) {				
				System.out.println("<ERROR> " + e + "\n");
			}
	}
}
