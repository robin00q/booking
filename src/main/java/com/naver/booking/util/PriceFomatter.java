package com.naver.booking.util;

public class PriceFomatter {

	public static String priceFormat(long price) {
		String priceString = String.valueOf(price);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(priceString.charAt(0));
		
		int pos = 1;
		
		while(pos < priceString.length()) {
			if( (priceString.length() - pos) % 3 == 0) {
				sb.append(',');
			}
			sb.append(priceString.charAt(pos));
			pos++;
		}
		
		return sb.toString();
	}
}
