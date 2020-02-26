package com.naver.booking.util;

public class EmailHidder {

	public static String emailHidder(String email) {
		
		StringBuilder sb = new StringBuilder(email);
		
		int emailLen = sb.length();
		while(emailLen-- > 0) {
			if(sb.charAt(emailLen) == '@') {
				return masking(sb.substring(0, emailLen));
			}
		}
		
		return masking(sb.toString());
	}
	
	private static String masking(String parsedEmail) {
		if(parsedEmail.length() >= 4) {
			parsedEmail = parsedEmail.substring(0, 4);
		}
		return parsedEmail + "****";
	}
}
