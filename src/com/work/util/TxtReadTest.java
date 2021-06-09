package com.work.util;

import java.io.File;
import java.io.FileReader;

public class TxtReadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * <pre>
	 * .txt파일의 데이터를 불러와서 Array등의 자료형으로 만들어 사용하기 위한 테스트
	 * </pre>
	 */
	public static void txtFileReadTest() {
		try {
			File file = new File("./memberlist.txt");
			FileReader fr = new FileReader(file);
			int tempCh = 0;
			String tempS = "";
			while((tempCh = fr.read()) != -1) {
				if((char)tempCh == '[') { continue; }
				else if((char)tempCh == ']') { continue; }
				if((char)tempCh != -1 && (char)tempCh != '/' ) {
					System.out.print((char)tempCh);
					tempS += (char)tempCh;
				} else if((char)tempCh == ',') {
					
				}
			}
			fr.close();
		} catch (Exception e) {
			System.out.println("<ERROR> " + e + "\n");
		}
	}


}
