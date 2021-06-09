package com.ex01.view;

import java.util.ArrayList;

import com.ex01.dto.item.Item;
import com.ex01.dto.item.OrderedList;
import com.ex01.dto.member.AdminMember;
import com.ex01.dto.member.GeneralMember;
import com.ex01.dto.member.Member;
import com.ex01.dto.member.ProviderMember;

public class ExecuteTest {
	public static void main(String[] args) throws Exception {
		System.out.println("<System> Program has started!!");
		
		ArrayList<Member> memberList = new ArrayList();	
		ArrayList<Item> itemList = new ArrayList();
		ArrayList<OrderedList> orderedList = new ArrayList(); 
		
		AdminMember m01 = new AdminMember("admin01", "1234", "admin01", "01012340001", "Seoul" ,"admin@ex01.com", "2021-05-17 00:00:00");		
		GeneralMember m02 = new GeneralMember("gruzam0615", "1234", "PMJ", "01050401234", "Seoul", "gruzam0615@ex01.com", "2021-05-17 00:00:00");
		ProviderMember m03 = new ProviderMember("provider01", "1234", "provider01", "07023451698", "Gyeonggi", "provider01@ex01.com", "2021-05-17 01:00:01");
		
		memberList.add(m01);
		memberList.add(m02);
		memberList.add(m03);		
		
		int idx = 0;		
		Item i01 = new Item(++idx, "Jordan 1 OG High", "Nike", "Shoes", 198000, 299, "provider01");
		Item i02 = new Item(++idx, "Yeezy Foam Runner", "Adidas", "Shoes", 99000, 100, "provider01");
		Item i03 = new Item(++idx, "T-shirts", "NoName", "Clothe", 10000, 999, "provider02");
		Item i04 = new Item(++idx, "Blanche", "byredo", "Perfume", 218500, 800, "provider03");		
		
		itemList.add(i01);
		itemList.add(i02);
		itemList.add(i03);
		itemList.add(i04);
		
		int oIdx = 0;
		OrderedList ol01 = new OrderedList(++oIdx, 1, "Jordan 1 OG High", 1, "gruzam0615", "2021-06-09 10:26:30");
		
		orderedList.add(ol01);
		
		
		MainView mv = new MainView();
		MainView.callMainView(memberList, itemList, orderedList);
	}	
}
