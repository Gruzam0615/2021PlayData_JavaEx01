package com.ex01.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.ex01.dto.item.Item;
import com.ex01.dto.item.OrderedList;
import com.ex01.dto.member.AdminMember;
import com.ex01.dto.member.GeneralMember;
import com.ex01.dto.member.Member;
import com.ex01.dto.member.ProviderMember;
import com.ex01.view.AfterSignInAdminView;
import com.ex01.view.AfterSignInGeneralView;
import com.ex01.view.AfterSignInProviderView;

public class SignInService {

	public static void signInMethod(ArrayList<Member> memberList, ArrayList<Item> itemList, ArrayList<OrderedList> orderedList, String memberAccount, String memberPassword) throws Exception {
		Member dto = null;
		Member answer = null;
		
		for(int i = 0; i < memberList.size(); i++) {
			dto = memberList.get(i);
			if(dto.getMemberAccount().equals(memberAccount)) {
				if(dto.getMemberAccount().equals(memberAccount) && dto.getMemberPassword().equals(memberPassword)) {
					DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String ct = f.format(new Date());
					
					if(dto instanceof GeneralMember) {
						System.out.println("<System> 일반회원 " + dto.getMemberName() + "\n<System> Time: " + ct + "\n");
						
						String pt = dto.getLastSignInDate();
						SimpleDateFormat tf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						
						Date npt = tf.parse(pt);
						Date nct = new Date(System.currentTimeMillis());
						
						if(nct.after(npt) == true) {
							if(!pt.substring(0, 10).equals(ct.substring(0, 10))) {
								System.out.println("출석으로 마일리지가 100점이 추가되었습니다.");
								int tempM = dto.getMeberMileage();
								tempM = tempM + 100;
								((GeneralMember) dto).setMemberMileage(tempM);
							}								
						}
						dto.setLastSignInDate(ct);
						System.out.println("<System> Welcome back " + memberAccount + "!!\n");
						AfterSignInGeneralView.callAfterSign(memberList, itemList, orderedList, dto);
						
					} else if(dto instanceof ProviderMember) {
						System.out.println("<System> 판매자회원 " + dto.getMemberName() + "\n<System> Time: " + ct + "\n");

						String pt = dto.getLastSignInDate();
						SimpleDateFormat tf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Date npt = tf.parse(pt);
						Date nct = new Date(System.currentTimeMillis());
						
						if(nct.after(npt) == true) {
							if(!pt.substring(0, 10).equals(ct.substring(0, 10))) {
								System.out.println("출석으로 마일리지가 100점이 추가되었습니다.");
								int tempM = dto.getMeberMileage();
								tempM = tempM + 100;
								((ProviderMember) dto).setMemberMileage(tempM);
							}								
						}
						dto.setLastSignInDate(ct);
						System.out.println("<System> Welcome back " + memberAccount + "!!\n");
						AfterSignInProviderView.callAfterSign(memberList, itemList, orderedList, (ProviderMember)dto);
						
					} else if(dto instanceof AdminMember) {
						System.out.println("<System> 관리자 " + dto.getMemberName() + "\n<System> Time: " + ct + "\n");
						dto.setLastSignInDate(ct);
						System.out.println("<System> Welcome back " + memberAccount + "!!\n");
						AfterSignInAdminView.callAfterSign(memberList, itemList, orderedList, (AdminMember)dto);
					}
					
//					System.out.println("<System> Welcome back " + memberAccount + "!!\n");
//					AfterSignInView.callAfterSign(list, dto);
				} else {
					System.out.print("<System> 잘못된 로그인 정보입니다.\n");
				}
			} 
		}
	}
}
