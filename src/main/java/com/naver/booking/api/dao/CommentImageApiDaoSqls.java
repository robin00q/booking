package com.naver.booking.api.dao;

public class CommentImageApiDaoSqls {
	
	public static final String SELECT_DISPLAY_INFO_IMAGE_ID_AND_FILE_INFOS = 
			"SELECT " + 
			"display_info_image.id AS image_id, " + 
			"file_info.id AS file_id, " + 
			"file_info.file_name AS file_name, " + 
			"file_info.save_file_name AS save_file_name, " + 
			"file_info.content_type AS content_type, " + 
			"file_info.delete_flag AS delete_flag, " + 
			"file_info.create_date AS create_date, " + 
			"file_info.modify_date AS modify_date " + 
			"FROM file_info " + 
			"INNER JOIN display_info_image " + 
			"ON file_info.id = display_info_image.file_id";
	
	public static final String SELECT_COMMENT_IMAGE_API = 
			"SELECT " + 
			"joined.image_id AS image_id, " + 
			"reservation_user_comment_image.reservation_info_id AS reservation_info_id, " + 
			"reservation_user_comment_image.reservation_user_comment_id AS reservation_user_comment_id, " + 
			"joined.file_id AS file_id, " + 
			"joined.file_name AS file_name, " + 
			"joined.save_file_name AS save_file_name, " + 
			"joined.content_type AS content_type, " + 
			"joined.delete_flag AS delete_flag, " + 
			"joined.create_date AS create_date, " + 
			"joined.modify_date AS modify_date " + 
			"FROM reservation_user_comment_image " + 
			"INNER JOIN (" + 
			SELECT_DISPLAY_INFO_IMAGE_ID_AND_FILE_INFOS + 
			") AS joined " + 
			"ON reservation_user_comment_image.file_id = joined.file_id";
	
}
