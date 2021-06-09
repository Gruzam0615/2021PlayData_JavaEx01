package com.ex01.dto.item;

public class OrderedList {
	
	/** 주문 번호 */
	private int orderIndex;
	/** 주문 상품 번호 */
	private int orderItemIndex;
	/** 주문 상품 이름 */
	private String orderItemName;
	/** 주문 상품 수량 */
	private int orderItemQuantity;
	/** 주문한 사람 */
	private String orderMember;
	/** 주문한 날짜 */
	private String orderDate;
	
	public int getOrderIndex() {
		return orderIndex;
	}
	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}
	public int getOrderItemIndex() {
		return orderItemIndex;
	}
	public void setOrderItemIndex(int orderItemIndex) {
		this.orderItemIndex = orderItemIndex;
	}
	public String getOrderItemName() {
		return orderItemName;
	}
	public void setOrderItemName(String orderItemName) {
		this.orderItemName = orderItemName;
	}
	public int getOrderItemQuantity() {
		return orderItemQuantity;
	}
	public void setOrderItemQuantity(int orderItemQuantity) {
		this.orderItemQuantity = orderItemQuantity;
	}
	public String getOrderMember() {
		return orderMember;
	}
	public void setOrderMember(String orderMember) {
		this.orderMember = orderMember;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	/** 기본 생성자 */
	public OrderedList() {}
	
	/**
	 * <pre>
	 * 주문목록 생성자
	 * </pre>
	 * 
	 * @param orderItemIndex
	 * @param orderItemName
	 * @param orderItemQuantity
	 * @param orderMember
	 * @param orderDate
	 */
	public OrderedList(int orderItemIndex, String orderItemName, int orderItemQuantity, String orderMember, String orderDate) {
		this.orderItemIndex = orderItemIndex;
		this.orderItemName = orderItemName;
		this.orderItemQuantity = orderItemQuantity;
		this.orderMember = orderMember;
		this.orderDate = orderDate;
	}
	
	public OrderedList(int orderIndex, int orderItemIndex, String orderItemName, int orderItemQuantity, String orderMember, String orderDate) {
		this.orderIndex = orderIndex;
		this.orderItemIndex = orderItemIndex;
		this.orderItemName = orderItemName;
		this.orderItemQuantity = orderItemQuantity;
		this.orderMember = orderMember;
		this.orderDate = orderDate;
	}
	
	@Override
	public String toString() {
		return "OrderedList [" + orderIndex + ", " + orderItemIndex + ", " + orderItemName + ", " + orderItemQuantity
				+ ", " + orderMember + ", " + orderDate + "]";
	}	
	
}
