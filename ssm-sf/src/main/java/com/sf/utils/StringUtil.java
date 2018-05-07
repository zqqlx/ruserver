package com.sf.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
*	FileName: StringUtils.java
*   @Description TODO
* 	@author zqq
*   @Version V1.0
*   create 2017��10��14�� ����8:16:17
*/
public class StringUtil {

	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
//	private static boolean isNotEmpty(Object obj){
//		if(obj == null){
//			return false;
//		}
//		if(obj instanceof String){
//			return !(((String)obj).isEmpty() || "null".equals((String)obj));
//		}else if(obj instanceof Collection){
//			return !((Collection)obj).isEmpty();
//		}else if(obj instanceof Map){
//			return !((Map)obj).isEmpty();
//		}
//		return true;
//	}
	
	public static boolean isMoreThanZero(String digit){
		String regex = "[1-9][0-9]*\\.\\d+|0\\.[0-9]*[1-9][0-9]*";
		return digit.matches(regex);
	}
	
	public static String toDateFormatString(Date date){
		if(date != null){
			SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
			return dateFormat.format(date);
			
		}
		return null;
	}
	
	public static Date toStringFormatDate(String str) throws ParseException{
		if(StringUtils.isNotEmpty(str)){
			SimpleDateFormat s = new SimpleDateFormat(DATE_FORMAT);
			return s.parse(str);
		}
		return null;
	}
	
	public static boolean isInt(String digit){
		if(StringUtils.isNotEmpty(digit)){
			String regex = "\\d*";
			return digit.matches(regex);
		}
		return false;
	}
	
	public static boolean isNumeric(String digit){
		if(StringUtils.isNotEmpty(digit)){
			if(isInt(digit)){
				return true;
			}else{
				String regex = "\\.\\d*$";
				String newDigit = digit.replaceAll(regex, "");
				String newRegex = "[-+]\\d+";
				return newDigit.matches(newRegex);
						
			}
		}
		return false;
	}
	
	public static String removeMoreZeroAtLast(String digit){
		if(StringUtils.isNotEmpty(digit)){
			if(digit.indexOf(".") > 0){
				String newDigit  = digit.replaceAll("0+?$", "");
				newDigit = newDigit.replaceAll("[.]$", "");
				return newDigit;
			}else{
				return digit;
			}
		}
		return null;
				
	}
	public static void main(String []args){
		String str = "";
		List list = new ArrayList();
		//System.out.println(isNotEmpty(list));
		//.out.println(isNotEmpty(str));
		System.out.println(isMoreThanZero("0.010"));
		System.out.println(toDateFormatString(new Date()));
		System.out.println(isInt("0.10"));
		System.out.println(isNumeric("-0.9"));
	}
}
