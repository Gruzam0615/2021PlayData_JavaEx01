package com.ex01.dto.member;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * -- Encapsulation Design
 * 
 * @author gruzam0615
 * @since openjdk15
 * @version 0.1
 * 
 * memberId : 회원번호 : 기본키
 * memberAccount : 회원계정 사용자가 로그인할 때 사용
 * memberPassword : 회원계정의 비밀번호
 * memberName : 회원이름
 * memberMobile : 회원 휴대폰 연락처
 * memberAddress : 회원 주소
 * memberEmail : 회원 이메일
 * memberRank : 회원등급 (일반회원 == "G" | 우수회원 == "S" | 판매자 == "P" | 운영 == "A")
 * memberEmployee : 회원전담 담당자
 * memberMileage : 회원이 보유한 마일리지
 * memberCreatedDate : 회원정보 생성일(회원 가입한날짜)
 * lastSigInDate : 최근에 로그인을 완료한 시간
 * modifiedDate : 회원정보를 마지막으로 수정한 시간
 */

public class Member {
	/** memberId : 회원번호 : 기본키 */
	private int memberIndex;
	/** 사용자가 로그인할 때 사용 */
	private String memberAccount;
	/** 로그인 비밀번호 */
	private String memberPassword;
	/** 사용자의 이름 */
	private String memberName;
	/** 사용자의 모바일 번호 */
	private String memberMobile;
	/** 사용자의 주소*/
	private String memberAddress;
	/** 사용자의 이메일 주소 */
	private String memberEmail;
	/** 사용자의 등급 일반("G") 우수("S") 판매자("P") 관리자("A") */
	private String memberRank;
	/** 사용자가 보유한 마일리지 */
	private int memberMileage;
	/** 사용자의 서비스 가입일 */
	private String memberCreatedDate;
	/** 사용자의 최근 로그인 일 */
	private String lastSignInDate;
	/** 사용자의 마지막 정보 수정시간 */
	private String modifiedDate;
	
	public String getMemberAccount() {
		return memberAccount;
	}
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
	public void seMemberMileage(int mileage) {
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
	
	public Member() {}

	/**
	 * 
	 * @param memberAccount
	 * @param memberPassword
	 * @param memberName
	 * @param memberMobile
	 * @param memberAddress
	 * @param memberEmail
	 */
	public Member(String memberAccount, String memberPassword, String memberName, String memberMobile, String memberAddress, String memberEmail) {
	
		this.memberAccount = memberAccount;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberMobile = memberMobile;
		this.memberAddress = memberAddress;
		this.memberEmail= memberEmail;
//		DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String time = f.format(new Date());
//		this.memberCreatedDate = time;
//		this.modifiedDate = time;
	};
	
	public String toString() {
		return "[ " + memberAccount + ", " + memberName + ", " + memberMobile + ", " + memberAddress + ", "
				+ memberEmail + ", " + memberRank + ", " + memberMileage + ", " + "생성일: " + getMemberCreatedDate() + ", "
				+ "마지막 로그인: " + getLastSignInDate() + ", " + "마지막 정보 수정일: " + getModifiedDate() +  "]";
	}
		
}