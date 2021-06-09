package com.ex01.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.ex01.dto.item.Item;
import com.ex01.dto.item.OrderedList;
import com.ex01.dto.member.Member;
import com.ex01.view.AfterSignInGeneralView;
import com.work.util.CurrentDate;

public class OrderItemService {

	public static void callOrderService(ArrayList<Member> memberList, ArrayList<Item> itemList, ArrayList<OrderedList> orderedList, String itemIndex, String orderQuantity, Member m) {
		Item oi = null;
		int index = Integer.parseInt(itemIndex);
		int Quantity = Integer.parseInt(orderQuantity);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < itemList.size(); i++) {
			if(itemList.get(i).getItemIndex() == index) {				
				System.out.println("<System> 아래에 표시된 주문 항목을 확인해주세요.\n");
				System.out.println("<System> " + itemList.get(i).getItemName() + " 를(을) "
						+ Quantity + "개 구매 하시겠습니까?");
				System.out.println("<System> 구매를 진행하시려면 y 취소하시려면 n을 입력해주세요.");
				try {
					int input = br.read();
					switch((char)input) {
						case ('y'): {
							int stock = itemList.get(i).getItemQuantity();
							stock = stock - Quantity;
							itemList.get(i).setItemQuantity(stock);							
							
							String tn = itemList.get(i).getItemName();
							OrderedList tempDto = new OrderedList((orderedList.size()+1), index, tn, Quantity, m.getMemberAccount(), CurrentDate.getCurrentDate());
							orderedList.add(tempDto);
							
							System.out.println("<System> 구매가 완료되었습니다. 메인화면으로 돌아갑니다.");
							AfterSignInGeneralView.callAfterSign(memberList, itemList, orderedList, m);
						}
						case ('n'): {
							System.out.println("<System> 구매가 취소되었습니다. 메인화면으로 돌아갑니다.");
							break;
						}
					}
				} catch(IOException e) {
					System.out.println("<ERROR> " + e);
				}
			}
		}		
	}

}
