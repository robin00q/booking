package com.naver.booking.util;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeFormatter {
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

	public static String LocalDateTimeFormatter(LocalDateTime localDateTime) {
		return localDateTime.format(formatter);
	}
	
	public static LocalDateTime DateToLocalDateTime(Timestamp timestamp) {
		if(timestamp != null) {
			return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp.getTime()), ZoneId.systemDefault());
		} else {
			return null;
		}
	}
}
