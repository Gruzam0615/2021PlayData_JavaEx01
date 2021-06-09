package com.work.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputTest {

	public static void main(String[] args) throws IOException {
		inputTest();
	}
	
	public static void inputTest() throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("<System> Enter A: ");
		String temp01 = br.readLine();
		System.out.println("<System> Enter B: ");
		String temp02 = br.readLine();
		br.close();
		
		System.out.println("temp01: " + temp01);
		System.out.println("temp02: " + temp02);
	}
}
