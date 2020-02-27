package com.naver.booking.dao;

public class DisplayInfoImageDaoSqls {

	public static final String SELECT_DISPLAY_INFO_SAVE_FILE_NAME = 
			"SELECT" + 
			"	file_info.save_file_name as save_file_name " + 
			"FROM" + 
			"	file_info " + 
			"INNER JOIN" + 
			"	display_info_image " + 
			"ON" + 
			"	display_info_image.file_id = file_info.id " + 
			"INNER JOIN" + 
			"	display_info " + 
			"ON" +
			"	display_info_image.display_info_id = display_info.id " + 
			"WHERE" +
			"	display_info.product_id = :productId";
}
