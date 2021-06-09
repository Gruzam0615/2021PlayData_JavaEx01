package com.ex01.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.ex01.dto.item.Item;
import com.ex01.dto.item.OrderedList;
import com.ex01.dto.member.Member;
import com.ex01.service.AdminService;

public class AfterSignInAdminView {

	public static void callAfterSign(ArrayList<Member> memberList, ArrayList<Item> itemList, ArrayList<OrderedList> orderedList, Member m) throws IOException {
		BufferedReader br = null;
		String input = "";
		boolean flag = true;
		try {
			while(flag) {
				System.out.println("");
				System.out.println("1. 회원 전체 목록 조회는 1");
				System.out.println("3. 판매중인 상품 목록 보기 3");
				System.out.println("7. 로그아웃은 7");
				System.out.println("0. 프로그램 종료는 0 또는 esc를");
				System.out.println("입력 후 Enter키를 눌러주세요.");
				br = new BufferedReader(new InputStreamReader(System.in));
				input = br.readLine();
				
				ArrayList<Item> iL = itemList;
		
					switch(input) {
					case ("1"): {
						System.out.println("<System>모든 회원 정보를 표시합니다.\n");
						AdminService.allMemberList(memberList);
						break;
					}
//					case ("2"): {
//						System.out.printf("\n<System> %s 님의 회원정보를 수정합니다.\n", m.getMemberAccount());
//						SetMemberInfoView.callSetMeberInfo(memberList, itemList, m);
//						break;
//					}
					case ("3"): {
						System.out.println("<System> 판매중인 상품 목록을 출력 합니다.\n");						
						AdminService.allItemList(itemList);
						break;
					}
					/** case 4 상품 삭제 */
					
					/** 로그아웃 */
					case ("7"): {
						MainView.callMainView(memberList, itemList, orderedList);
						break;
					}
					case ("0"): {
						System.out.println("<System> You typed 0 \n<System> All Program going shutdown...");
						System.exit(0);
					}
					case ("esc"): {
						System.out.println("<System> You typed \"esc\" \n<System> All Program going shutdown...");
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
