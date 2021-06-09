package com.work.util;

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
	 * @return currentDate
	 */
	public static String getCurrentDate() {
		Date time = new Date();
		String currentDate = "";
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		currentDate = f.format(time);
		return currentDate;
	}
	
}
