package com.ex01.service;

import java.util.ArrayList;

import com.ex01.dto.item.Item;
import com.ex01.dto.member.Member;

public class ProviderService {

	public static void viewAllMyItem(ArrayList<Member> memberList, ArrayList<Item> itemList, Member m) {
		for(int i = 0; i < itemList.size(); i++) {
			if(itemList.get(i).getItemProvider().equals(m.getMemberAccount())) {
				System.out.println(itemList.get(i).toString());
			}
		}
		System.out.println();
	}

}
