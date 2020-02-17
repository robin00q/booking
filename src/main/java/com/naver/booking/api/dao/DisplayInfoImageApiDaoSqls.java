package com.naver.booking.api.dao;

public class DisplayInfoImageApiDaoSqls {

	public static final String SELECT_DISPLAY_INFO_IMAGE_API = 
			"SELECT " + 
			"display_info_image.id as display_info_image_id, " + 
			"display_info_image.display_info_id as display_info_id, " + 
			"display_info_image.file_id as file_id, " + 
			"file_info.file_name as file_name, " + 
			"file_info.save_file_name as save_file_name, " + 
			"file_info.content_type as content_type, " + 
			"file_info.delete_flag as delete_flag, " + 
			"file_info.create_date as create_date," + 
			"file_info.modify_date as modify_date " + 
			"FROM display_info_image " + 
			"INNER JOIN file_info " + 
			"ON display_info_image.file_id = file_info.id " + 
			"WHERE display_info_image.display_info_id = :displayInfoId";
}
