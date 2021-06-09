package com.ex01.service;

import java.util.ArrayList;

import com.ex01.dto.item.Item;
import com.ex01.dto.member.AdminMember;
import com.ex01.dto.member.Member;

public class AdminService {

	public static void allMemberList(ArrayList<Member> memberList) {
		for(int i = 0; i < memberList.size(); i++) {
			if(!(memberList.get(i) instanceof AdminMember)) {
				System.out.println(memberList.get(i).toString());
			}
		}
	}

	public static void allItemList(ArrayList<Item> itemList) {
		for(int i = 0; i < itemList.size(); i++) {
			System.out.println(itemList.get(i).toString());
		}		
	}

}
