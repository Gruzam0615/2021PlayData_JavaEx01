package com.ex01.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.ex01.dto.item.Item;
import com.ex01.dto.item.OrderedList;
import com.ex01.dto.member.GeneralMember;
import com.ex01.dto.member.Member;
import com.ex01.dto.member.ProviderMember;
import com.ex01.service.SetMemberService;

/**
 * 
 * @author mj
 * 
 * <pre>
 * 로그인 한 사용자가 자신의 정보를 수정하기 위해 호출하는 View
 * </pre>
 */
public class SetMemberInfoView {
	public static void callSetMeberInfo(ArrayList<Member> memberList, ArrayList<Item> itemList, ArrayList<OrderedList> orderedList, Member m) {
		BufferedReader br = null;
		String input = "";
		boolean flag = true;
		try {
			while(flag) {
				System.out.println("");
				System.out.println("1. 비밀번호 변경은 1");
				System.out.println("2. 연락처 변경 2");
				System.out.println("3. 주소 변경 3");
				System.out.println("4. 이메일 변경 4");
				System.out.println("5. 이전 메뉴는 5");
				System.out.println("0. 프로그램 종료는 0 또는 esc를");
				System.out.println("입력 후 Enter키를 눌러주세요.");
				br = new BufferedReader(new InputStreamReader(System.in));
				input = br.readLine();
				print(input);		
		
					switch(input) {
					case ("1"): {
						System.out.printf("\n<System> %s 님의 비밀번호를 변경합니다.\n", m.getMemberAccount());
						SetMemberService.setMemberPassword(memberList, m);
						break;
					}
					case ("2"): {
						System.out.printf("\n<System> %s 님의 핸드폰번호를 변경합니다.\n", m.getMemberAccount());
						SetMemberService.setMemberMobile(memberList, m);
						break;
					}
					case ("3"): {
						System.out.printf("\n<System> %s 님의 주소를 변경합니다.\n", m.getMemberAccount());
						SetMemberService.setMemberAddress(memberList, m);
						break;
					}
					case ("4"): {
						System.out.printf("\n<System> %s 님의 이메일 주소를 변경합니다.\n", m.getMemberAccount());
						SetMemberService.setMemberEmail(memberList, m);
						break;
					}
					
					case ("5"): {
						System.out.printf("\n이전화면으로 돌아갑니다.\n");
						if(m instanceof GeneralMember) {
							AfterSignInGeneralView.callAfterSign(memberList, itemList, orderedList, m);
						} else if(m instanceof ProviderMember) {
							AfterSignInProviderView.callAfterSign(memberList, itemList, orderedList, m);
						}
						
					}
					case ("0"): {
						System.out.println("<System> You typed 0 \n<System> All Program going shutdown...");
						System.exit(0);
					}
					case ("esc"): {
						System.out.println("<System> You typed \"esc\" \n<System> All Program going shutdown...");
						System.exit(0);
					}
					default: System.out.print("default");
					}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void print(String input) {		
		System.out.printf("<typed> %s \n", input);
	}
	
}
