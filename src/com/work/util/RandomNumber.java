package com.work.util;

/**
 * <pre>
 * - Generate MemberIndex
 * </pre>
 * @author gruzam0615
 *
 */

public class RandomNumber {
	
//	public static void main(String[] args) {
//		System.out.println(randomMemberIndex());
//	}
	
	
	//8자리의 난수를 인덱스로 활용할 경우
	public static int randomMemberIndex() {
		int answer = 0;		
		int temp = (int) Math.round((Math.random() * 100000000));
		answer = temp;		
		return answer;
	}
	
	//5자리의 난수를 상품인덱스번호로 활용
	public static int randomItemIndex() {
		int answer = 0;
		 int temp = (int) Math.round((Math.random() * 100000));
		 answer = temp;
		 return answer;
	}
	
}
