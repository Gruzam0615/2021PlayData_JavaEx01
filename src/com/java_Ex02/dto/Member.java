package com.java_Ex02.dto;

import com.java_Ex02.util.CurrentDate;

public class Member {
	private String memberAccount;
	private String memberPassword;
	private String name;
	private String mobile;
	private String address;
	private String email;
	private String rank;
	private int mileage;
	private String entryDate;
	private String lastDate;
	private String modifiedDate;
	public String getMemberAccount() {
		return memberAccount;
	}
	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	public String getLastDate() {
		return lastDate;
	}
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	public Member() {}
	
	public Member(String memberAccount, String memberPassword, String name, String mobile, String address, String email, String rank) {
		this.memberAccount = memberAccount;
		this.memberPassword = memberPassword;
		this.name = name;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
		this.rank = rank;
		this.mileage = 1000;
		CurrentDate cd = new CurrentDate();
		this.entryDate = cd.getCurrentDate();
		this.lastDate = "";
		this.modifiedDate = this.entryDate;		
	}
	
	public Member(String memberAccount, String name, String mobile, String address, String email, String rank, int mileage, String entryDate, String lastDate, String modifiedDate) {
		this.memberAccount = memberAccount;
		this.name = name;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
		this.rank = rank;
		this.mileage = mileage;
		this.entryDate = entryDate;
		this.lastDate = lastDate;
		this.modifiedDate = modifiedDate;		
	}
	
	@Override
	public String toString() {
		return "Member [" + memberAccount + ", " + name + ", " + mobile + ", " + address + ", " + email + ", " + rank
				+ ", " + mileage + ", " + entryDate + ", " + lastDate + ", " + modifiedDate + "]";
	}	
	
}
