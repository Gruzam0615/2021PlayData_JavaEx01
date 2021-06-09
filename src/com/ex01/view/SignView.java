package com.ex01.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.ex01.dto.item.Item;
import com.ex01.dto.item.OrderedList;
import com.ex01.dto.member.GeneralMember;
import com.ex01.dto.member.Member;
import com.ex01.dto.member.ProviderMember;
import com.ex01.service.SignInService;
/**
 * 
 * @author gruzam0615
 * @version 1.0
 * @since openjdk15
 *
 */
public class SignView {
	/**
	 * <pre>
	 * </pre>
	 * @param memberList
	 * @param itemList
	 */
	public static void callSignUpView(ArrayList<Member> memberList, ArrayList<Item> itemList, ArrayList<OrderedList> orderedList) {
		boolean flag = true;
		
		try {
			BufferedReader br = null;
			String input = "";
			
			String[] splitInput = new String[7];
					
			System.out.print("<System> 아래의 형식에 맞춰 회원정보를 입력해주세요.\n");
			System.out.println("계정, 비밀번호, 이름, 휴대전화번호, 주소, 이메일, g 또는 p");
			System.out.println("<System> 휴대전화번호의 경우 하이픈(-)을 제외한 숫자만 입력해주세요.");
			System.out.println("<System> 마지막 항목의 경우 일반회원은 g, 판매자회원은 p를 입력해주세요.");
			
			br = new BufferedReader(new InputStreamReader(System.in));
//			System.out.println("<System> 계정을 입력하세요.");
//			String inputAccount = br.readLine();
//			String inputPassword = br.readLine();
//			String inputName = br.readLine();
//			String inputMobile = br.readLine();
//			String inputAddress = br.readLine();
//			String inputEmail = br.readLine();
//			String inputRoll = br.readLine();
			input = br.readLine();
				
			String[] tempInput = input.split(",");
				
			for(int i = 0; i < splitInput.length; i++) {
				if(tempInput[i] != "") {
					splitInput[i] = tempInput[i].trim().toLowerCase();
				} else {
					System.out.println("<ERROR> 잘못된 입력입니다. 이전 화면으로 돌아갑니다.\n");
					break;
				}
				
			}
			
			/** 아이디 중복 검사 */
			for(int j = 0; j < memberList.size(); j++) {
				if(memberList.get(j).getMemberAccount().equals(splitInput[0])) {
					System.out.println("<ERROR> 입력하신 계정 "+ splitInput[0] + "는(은) 이미 존재하는 계정입니다.");
					flag = false;
					break;
				}
			}
			/** 휴대폰 번호 중복 검사 */
			for(int j = 0; j < memberList.size(); j++) {
				if(memberList.get(j).getMemberMobile().equals(splitInput[3])) {
					System.out.println("<ERROR> 입력하신 휴대폰 번호 "+ splitInput[3] + "는(은) 이미 존재하는 휴대폰 번호입니다.");
					flag = false;
					break;
				}
			}
			/** 이메일 주소 중복 검사 */
			for(int j = 0; j < memberList.size(); j++) {
				if(memberList.get(j).getMemberEmail().equals(splitInput[5])) {
					System.out.println("<ERROR> 입력하신 이메일 주소 "+ splitInput[5] + "는(은) 이미 존재하는 이메일 주소입니다.");
					flag = false;
					break;
				}
			}			
			
			if(splitInput[6].equals("g") && flag == true) {
				GeneralMember dto = new GeneralMember(splitInput[0], splitInput[1], splitInput[2], splitInput[3], splitInput[4], splitInput[5]);
				memberList.add(dto);
				System.out.println("<System> " + dto.getMemberName() + "님의 가입을 환영합니다.");
				MainView.callMainView(memberList, itemList, orderedList);
			} else if(splitInput[6].equals("p") && flag == true) {
				ProviderMember dto = new ProviderMember(splitInput[0], splitInput[1], splitInput[2], splitInput[3], splitInput[4], splitInput[5]);
				memberList.add(dto);
				System.out.println("<System> " + dto.getMemberName() + "님의 가입을 환영합니다.");
				MainView.callMainView(memberList, itemList, orderedList);
			}
		} catch(Exception e) {		
			System.out.println("<ERROR> 잘못된 입력입니다. 이전 화면으로 돌아갑니다.\n");
		}
	}
	
	public static void callSignInView(ArrayList<Member> memberList, ArrayList<Item> itemList, ArrayList<OrderedList> orderedList) {
		BufferedReader br = null;
		String input = "";
		
		try {
			String[] splitInput = new String[2];
				
			System.out.print("<System> 아래의 형식에 맞춰 로그인 정보를 입력해주세요.\n");
			System.out.println("계정, 비밀번호");
				
			br = new BufferedReader(new InputStreamReader(System.in));
			input = br.readLine();
			String[] tempInput = input.split(",");
			for(int i = 0; i < splitInput.length; i++) {
				splitInput[i] = tempInput[i].trim();
			}				
			SignInService.signInMethod(memberList, itemList, orderedList, splitInput[0], splitInput[1]);
						
		} catch(Exception e) {
			System.out.println("<ERROR> 로그인 정보가 유효하지 않습니다. 이전 화면으로 돌아갑니다.\n");
			//e.printStackTrace();
		}
	}
}
