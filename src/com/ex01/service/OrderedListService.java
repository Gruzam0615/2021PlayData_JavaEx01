package com.ex01.service;

import java.util.ArrayList;

import com.ex01.dto.item.Item;
import com.ex01.dto.item.OrderedList;
import com.ex01.dto.member.Member;

public class OrderedListService {

	/**
	 * <pre>
	 * 사용자의 주문내역 조회를 위한 메서드
	 * </pre>
	 * @param memberList
	 * @param itemList
	 * @param orderedList
	 * @param m
	 */
	public static void callOrederedList(ArrayList<Member> memberList, ArrayList<Item> itemList,
			ArrayList<OrderedList> orderedList, Member m) {
		for(int i = 0; i < orderedList.size(); i++) {
			if(orderedList.get(i).getOrderMember().equals(m.getMemberAccount())) {
				System.out.println(orderedList.get(i).toString() + "\n");
			}
		}
		
	}

}
