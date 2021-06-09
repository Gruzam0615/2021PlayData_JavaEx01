package com.work.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre>
 * - Utility Class for Customizing Public Method
 * - All Method Using static
 * - Utility 클래스의 템플릿
 * </pre>
 * @author gruzam0615
 *
 */

public class Utility {
	
	public static String getCurrentDate() {
		Date time = new Date();
		String currentDate = "";
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		currentDate = f.format(time);
		return currentDate;
	}
	
	public static boolean emptyCheck(String input) {
		boolean answer = false;
		if(input != "") {
			answer = true;
		} else {
			answer = false;
		}
		return answer;
	}
	
}
