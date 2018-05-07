package com.sf.utils;

import java.math.BigDecimal;

/**
*	FileName: Arith.java
* 	@author zqq
*   @Version V1.0
*   create 2017��10��14�� ����9:23:30
*   @Description ()
*/
public class Arith {
	/**
	 * ʵ�������������
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static double add(double d1, double d2){
		BigDecimal b1 = new BigDecimal(String.valueOf(d1));
		BigDecimal b2 = new BigDecimal(String.valueOf(d2));
		BigDecimal sum = b1.add(b2);
		return sum.doubleValue();
	}
	/**
	 * ʵ�������������
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static double sub(double d1, double d2){
		BigDecimal b1 = new BigDecimal(String.valueOf(d1));
		BigDecimal b2 = new BigDecimal(String.valueOf(d2));
		BigDecimal sub  = b1.subtract(b2);
		return sub.doubleValue();
		
	}
	
	public static double div(double d1, double d2, int scale){
		BigDecimal b1 = new BigDecimal(d1);
		BigDecimal b2 = new BigDecimal(d2);
		if(scale < 0){
			throw new RuntimeException("The scale must be positive or zero");
		}
		return b1.divide(b2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public static double multiply(double d1, double d2){
		BigDecimal b1 = new BigDecimal(d1);
		BigDecimal b2 = new BigDecimal(d2);
		return b1.multiply(b2).doubleValue();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
