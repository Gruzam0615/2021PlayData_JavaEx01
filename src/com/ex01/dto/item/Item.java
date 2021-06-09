package com.ex01.dto.item;

import com.work.util.RandomNumber;

public class Item {
	/**
	 * <pre>
	 *	판매상품 속성 정의
	 * </pre>
	 */
	
	/** 상품 고유번호 */
	private int itemIndex;
	/** 상품 이름 */
	private String itemName;
	/** 상품 브랜드명 */
	private String itemBrand;
	/** 상품 대분류 */
	private String itemCategory1;
	/** 상품 가격 */
	private int itemPrice;
	/** 상품 재고 수 */
	private int itemQuantity;
	/** 상품 사이즈 */
//	private String itemSize;
	/** 상품 판매자 */
	private String itemProvider;
	
	public int getItemIndex() {
		return itemIndex;
	}
	public void setItemIndex(int itemIndex) {
		this.itemIndex = itemIndex;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemBrand() {
		return itemBrand;
	}
	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}
	public String getItemCategory1() {
		return itemCategory1;
	}
	public void setItemCategory1(String itemCategory1) {
		this.itemCategory1 = itemCategory1;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public String getItemProvider() {
		return itemProvider;
	}
	public void setItemProvider(String itemProvider) {
		this.itemProvider = itemProvider;
	}
	
	/**
	 * <pre>
	 * Item 생성자
	 * </pre>
	 */
	public Item() {}
	/**
	 * <pre>
	 * Item 기본적인 생성자
	 * </pre>
	 * @param itemName
	 * @param itemBrand
	 * @param itemCategory1
	 * @param itemPrice
	 * @param itemQuantity
	 */
	public Item(int itemIndex, String itemName, String itemBrand, String itemCategory1, int itemPrice, int itemQuantity) {
		this.itemIndex = itemIndex;
		this.itemName = itemName;
		this.itemBrand = itemBrand;
		this.itemCategory1 = itemCategory1;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
	}
	
	public Item(int itemIndex, String itemName, String itemBrand, String itemCategory1, int itemPrice, int itemQuantity, String itemProvider) {
		this.itemIndex = itemIndex;
		this.itemName = itemName;
		this.itemBrand = itemBrand;
		this.itemCategory1 = itemCategory1;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
		this.itemProvider = itemProvider;
	}
	
	public String toString() {
		return "Item [" + itemIndex + ", " + itemName + ", " + itemBrand + ", " + itemCategory1 + ", " + itemPrice
				+ ", " + itemQuantity + "]";
	}
	
	
	
}
