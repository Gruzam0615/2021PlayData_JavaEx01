package com.ex01.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.ex01.dto.member.Member;

public class SetMemberService {

	public static void setMemberPassword(ArrayList<Member> list, Member m) {
		System.out.println("<System> 비밀번호 변경을 위해 아래의 형식에 맞춰 정보를 입력해주세요.");
		System.out.println("사용자 확인을 위한 기존의 비밀번호, 새로운 비밀번호, 새로운 비밀번호 확인");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		try {
			String[] tempInput = new String[3];
			
			input = br.readLine();
			String[] splitInput = input.split(",");
			
			for(int i = 0; i < tempInput.length; i++) {
				tempInput[i] = splitInput[i].trim();
			}
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getMemberAccount().equals(m.getMemberAccount())) {
					if(m.getMemberPassword().equals(tempInput[0])) {
						if(tempInput[1].equals(tempInput[2])) {
							list.get(i).setMemberPassword(tempInput[1]);
							System.out.println("<System> 비밀번호가 변경되었습니다.");
							break;
						}
					}
				}
			}				
			
		} catch(IOException e) {
			System.out.println("<Error> " + e + "\n");
		}
	}
	
	public static void setMemberMobile(ArrayList<Member> list, Member m) {
		System.out.println("<System> 등록된 핸드폰 번호 변경을 위해 아래의 형식에 맞춰 정보를 입력해주세요.");
		System.out.println("새로운 핸드폰 번호, 사용자 확인을 위한 비밀번호");
		System.out.println("<System> 기존의 핸드폰 번호는 " + m.getMemberMobile() + "\n");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		try {
			String[] tempInput = new String[2];
			
			input = br.readLine();
			String[] splitInput = input.split(",");
			
			for(int i = 0; i < tempInput.length; i++) {
				tempInput[i] = splitInput[i].trim();
			}
			
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getMemberAccount().equals(m.getMemberAccount())) {
					if(m.getMemberPassword().equals(tempInput[1])) {						
						list.get(i).setMemberMobile(tempInput[0]);
						System.out.println("<System> 새로운 핸드폰번호가 저장 되었습니다.");
						break;
					}
				}
			}
		} catch(IOException e) {
			System.out.println("<Error> " + e + "\n");
		}
	}
	
	public static void setMemberAddress(ArrayList<Member> list, Member m) {
		System.out.println("<System> 등록된 주소 변경을 위해 아래의 형식에 맞춰 정보를 입력해주세요.");
		System.out.println("새로운 주소, 사용자 확인을 위한 비밀번호");
		System.out.println("<System> 기존의 주소는 " + m.getMemberAddress() + "\n");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		try {
			String[] tempInput = new String[2];
			
			input = br.readLine();
			String[] splitInput = input.split(",");
			
			for(int i = 0; i < tempInput.length; i++) {
				tempInput[i] = splitInput[i].trim();
			}
			
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getMemberAccount().equals(m.getMemberAccount())) {
					if(m.getMemberPassword().equals(tempInput[1])) {						
						list.get(i).setMemberAddress(tempInput[0]);
						System.out.println("<System> 새로운 주소 " + tempInput[0] + " 가 저장 되었습니다.");
						break;
					}
				}
			}
		} catch(IOException e) {
			System.out.println("<Error> " + e + "\n");
		}
	}
	
	public static void setMemberEmail(ArrayList<Member> list, Member m) { //OUT
		System.out.println("<System> 등록된 이메일 주소 변경을 위해 아래의 형식에 맞춰 정보를 입력해주세요.");
		System.out.println("새로운 이메일 주소, 사용자 확인을 위한 비밀번호");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		try {
			String[] tempInput = new String[2];
			
			input = br.readLine();
			String[] splitInput = input.split(",");
			
			for(int i = 0; i < tempInput.length; i++) {
				tempInput[i] = splitInput[i].trim();
			}
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getMemberAccount().equals(m.getMemberAccount())) {
					if(m.getMemberPassword().equals(tempInput[1])) {
						list.get(i).setMemberEmail(tempInput[0]);
						System.out.println("<System> 새로운 이메일 주소가 저장 되었습니다.");
						break;
					}
				}
			}			
		} catch(IOException e) {
			System.out.println("<Error> " + e + "\n");
		}	
	}
	
}
