package com.naver.booking.dao;

public class DisplayInfoImageDaoSqls {

	public static final String SELECT_DISPLAY_INFO_IMAGE = 
			"SELECT" +
			"	product.id as product_id," +
			"	display_info.id as display_info_id," + 
			"	display_info.opening_hours as opening_hours," + 
			"	display_info.place_street as place_street," + 
			"	file_info.save_file_name as save_file_name " + 
			"FROM" +
			"	display_info " +
			"INNER JOIN" +
			"	product " + 
			"ON" +
			"	product.id = display_info.product_id " +
			"INNER JOIN" +
			"	product_image " + 
			"ON" +
			"	product.id = product_image.product_id " +
			"INNER JOIN" +
			"	file_info " +
			"ON" +
			"	product_image.file_id = file_info.id " +
			"WHERE" +
			"	display_info.id = :displayInfoId " + 
			"LIMIT" +
			" 	1 ";
}
