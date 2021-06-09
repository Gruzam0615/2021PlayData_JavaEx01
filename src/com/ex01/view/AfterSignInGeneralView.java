package com.ex01.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.ex01.dto.item.Item;
import com.ex01.dto.item.OrderedList;
import com.ex01.dto.member.Member;
import com.ex01.service.OrderedListService;

public class AfterSignInGeneralView {

	public static void callAfterSign(ArrayList<Member> memberList, ArrayList<Item> itemList, ArrayList<OrderedList> orderedList, Member m) throws IOException {
		BufferedReader br = null;
		String input = "";
		boolean flag = true;
		
		try {
			while(flag) {
				System.out.println("");
				System.out.println("1. 회원정보 조회는 1");
				System.out.println("2. 회원정보 수정은 2");
				System.out.println("3. 판매중인 상품 목록 보기는 3");
//				System.out.println("4. 장바구니에 담기는 4");
//				System.out.println("5. 장바구니 일괄 구매하기는 5");
				System.out.println("6. 상품 구매는 6");
				System.out.println("7. 주문한 상품 조회는 7");
				System.out.println("8. 로그아웃은 8");
				System.out.println("0. 프로그램 종료는 0 또는 esc를");
				System.out.println("입력 후 Enter키를 눌러주세요.");
				br = new BufferedReader(new InputStreamReader(System.in));
				input = br.readLine();
						
				switch(input) {
					case ("1"): {
						System.out.printf("\n<System> %s 정보를 표시합니다.\n", m.getMemberAccount());
						System.out.println(m.toString());
						break;
					}
					case ("2"): {
						System.out.printf("\n<System> %s 님의 회원정보를 수정합니다.\n", m.getMemberAccount());
						SetMemberInfoView.callSetMeberInfo(memberList, itemList, orderedList, m);
						break;
					}
					case ("3"): {
						System.out.println("<System> 판매중인 상품 목록을 출력 합니다.\n");						
						for(int i = 0; i < itemList.size(); i++) {
							System.out.println(itemList.get(i));
						}
						break;
					}
					case ("6"): {
						System.out.println("<System> 상품을 주문 합니다.\n");
						OrderItemView.callOrderItem(memberList, itemList, orderedList, m);
						break;
					}
					case ("7"): {
						System.out.println("<System> 주문한 상품을 조회합니다.\n");
						OrderedListService.callOrederedList(memberList, itemList, orderedList, m);
						break;
					}
					case ("8"): {
						MainView.callMainView(memberList, itemList, orderedList);
						break;
					}
					case ("0"): {
						System.out.println("<System> 0을 입력했습니다.\n<System> 프로그램을 종료합니다.");
						System.exit(0);
					}
					case ("esc"): {
						System.out.println("<System> \"esc\"를 입력했습니다.\n<System> 프로그램을 종료합니다.");
						System.exit(0);
					}
					default: System.out.println("<System> INPUT INCORRECT...\n");
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
