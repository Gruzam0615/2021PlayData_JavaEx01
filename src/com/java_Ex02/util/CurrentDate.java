package com.java_Ex02.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre>
 * - 현재 시간을 출력하기 위한 메서드
 * - 메서드가 호출되어 실행되는 때를 아래의 형식으로 출력
 * - yyyy-MM-dd HH:mm:ss 
 * </pre>
 * @author gruzam0615
 *
 */

public class CurrentDate {
	/**
	 * <pre>
	 * getCurrentDate() 메서드가 작동할 당시의 시간을
	 * yyyy-MM-dd HH:mm:ss 형태의 String 타입으로 출력
	 * </pre>
	 * @return currentDate
	 */
	public String getCurrentDate() {
		Date time = new Date();
		String currentDate = "";
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		currentDate = f.format(time);
		return currentDate;
	}
	
}
