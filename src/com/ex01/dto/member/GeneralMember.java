package com.ex01.dto.member;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.work.util.CurrentDate;
import com.work.util.RandomNumber;

/**
 * @author gruzam0615
 * @version 0.1
 * @since openjdk15
 * <pre>
 * 일반회원을 위한 설정
 * </pre>
 * 
* memberAccount : 회원계정 사용자가 로그인할 때 사용
* memberPassword : 회원계정의 비밀번호
* memberName : 회원이름
* memberMobile : 회원 휴대폰 연락처
* memberAddress: 회원 주소
* memberEmail : 회원 이메일
* memberRank : 회원등급 (일반회원)
* memberMileage : 회원이 보유한 마일리지
* memberCreatedDate : 회원정보 생성일(회원 가입한날짜)
*/

public class GeneralMember extends Member {	
	
	private int memberIndex;
	private String memberAccount;
	private String memberPassword;
	private String memberName;
	private String memberMobile;
	private String memberAddress;
	private String memberEmail;
	private String memberRank;
	private int memberMileage;
	private String memberCreatedDate;
	private String lastSignInDate;
	private String modifiedDate;
	
	public String getMemberAccount() {
		return memberAccount;
	}
//	public void setMemberAccount(String memberAccount) {
//		this.memberAccount = memberAccount;
//	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberMobile() {
		return memberMobile;
	}
	public void setMemberMobile(String memberMobile) {
		this.memberMobile = memberMobile;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberRank() {
		return memberRank;
	}
	public void setMemberRank(String memberRank) {
		this.memberRank = memberRank;
	}
	public int getMeberMileage() {
//		String answer = "";
//		DecimalFormat p = new DecimalFormat("###,###,###");
//		answer = Integer.toString(memberMileage);
//		answer = p.format(answer);
		return memberMileage;
	}
	public void setMemberMileage(int mileage) {
		this.memberMileage = mileage;
	}
	public String getMemberCreatedDate() {
		String answer = "";
		answer = memberCreatedDate.substring(0, 10); 
		return answer;
	}
	public String getLastSignInDate() {
		return lastSignInDate;
	}
	public void setLastSignInDate(String lastSignInDate) {
		this.lastSignInDate = lastSignInDate;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDateDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	/**
	 * <pre>
	 * 일반회원을 생성자
	 * </pre>
	 */
	public GeneralMember() {}
	
	/**
	 * <pre>
	 * 일반회원을 생성자
	 * </pre>
	 * 
	 * @param memberAccount
	 * @param memberPassword
	 * @param memberName
	 * @param memberMobile
	 * @param memberAddress
	 * @param memberEmail
	 */
	public GeneralMember(String memberAccount, String memberPassword, String memberName, String memberMobile, String memberAddress, String memberEmail) {				
		super();
		RandomNumber r = new RandomNumber();
		this.memberIndex = r.randomMemberIndex();
		this.memberAccount = memberAccount;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberMobile = memberMobile;
		this.memberAddress = memberAddress;
		this.memberEmail = memberEmail;
		this.memberRank = "G";
		this.memberMileage = 0;		
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = f.format(new Date());
		this.memberCreatedDate = time;
		this.lastSignInDate = "2000-01-01 00:00:00";
		this.modifiedDate = time;
	}
	
	public GeneralMember(String memberAccount, String memberPassword, String memberName, String memberMobile, String memberAddress, String memberEmail, String memberCreatedDate) {				
		RandomNumber r = new RandomNumber();
		this.memberIndex = r.randomMemberIndex();
		this.memberAccount = memberAccount;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberMobile = memberMobile;
		this.memberAddress = memberAddress;
		this.memberEmail = memberEmail;
		this.memberRank = "G";
		this.memberMileage = 0;		
		this.memberCreatedDate = memberCreatedDate;
		this.lastSignInDate = memberCreatedDate;
		this.modifiedDate = memberCreatedDate;
	}	
	
	@Override
	public String toString() {
		return "[ " + memberAccount + ", " + memberName + ", " + memberMobile + ", " + memberAddress + ", "
				+ memberEmail + ", " + memberRank + ", " + memberMileage + ", " + "생성일: " + getMemberCreatedDate() + ", "
				+ "마지막 로그인: " + getLastSignInDate() + ", " + "마지막 정보 수정일: " + getModifiedDate() +  "]";
	}
	
	
	
	
}
