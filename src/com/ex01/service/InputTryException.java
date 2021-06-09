package com.ex01.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InputTryException {

	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = null;
		String[] splitInput = new String[5];
		String[] tempInput = null;
		try {
			System.out.println("<System> 아래의 형식에 맞춰 5개 항목을 입력해주세요.");
			System.out.println("A, B, C, D, E");
			input = br.readLine();
			tempInput =  input.split(",");
				
			for(int i = 0; i < tempInput.length; i++) {
				if(!tempInput[i].isBlank()) {
					splitInput[i] = tempInput[i].trim();
				}
			}
			br.close();
			
			for(int i = 0; i < splitInput.length; i++) {
				if(splitInput[i] == null) {
					System.out.println("<System> 유효하지 않는 데이터 입니다.");
					break;
				}
			}
			System.out.println("<System> 입력값: " + Arrays.toString(splitInput) + "\n");
		
		} catch(Exception e) {
			System.out.println("<ERROR> " + e);
		}
	}

}
