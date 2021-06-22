package com.java_Ex02.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputString {

	public String inputString() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputString = null;
		try {
			
			boolean flag = true;
			while(flag) {
				inputString = br.readLine();
				if(inputString.isBlank()) {
//					System.out.println("<SYSTEM> : 입력값이 없습니다.");
					flag = false;
				} else {
					flag = false;
				}
			}
			
		} catch (IOException e) {
			System.out.println("<ERROR> : " + e);
		}
		return inputString;
	}
	
}
