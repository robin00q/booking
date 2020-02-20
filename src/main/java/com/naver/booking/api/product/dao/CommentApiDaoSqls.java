package com.naver.booking.api.product.dao;

public class CommentApiDaoSqls {
	
	public static final String SELECT_COMMENT_API = 
			"SELECT " + 
			"reservation_user_comment.id AS comment_id, " + 
			"reservation_user_comment.product_id AS product_id, " + 
			"reservation_user_comment.reservation_info_id AS reservation_info_id, " + 
			"reservation_user_comment.score AS score, " + 
			"reservation_user_comment.comment AS comment, " + 
			"reservation_info.reservation_name AS reservation_name, " + 
			"reservation_info.reservation_tel AS reservation_telephone, " + 
			"reservation_info.reservation_email AS reservation_email, " + 
			"reservation_info.reservation_date AS reservation_date, " + 
			"reservation_user_comment.create_date AS create_date, " + 
			"reservation_user_comment.modify_date AS modify_date " + 
			"FROM reservation_user_comment " + 
			"INNER JOIN reservation_info " + 
			"ON reservation_info.id = reservation_user_comment.reservation_info_id"; 
	
	public static final String SELECT_COMMENT_API_WITH_COMMENTS = 
			"SELECT" + 
			"	reservation_user_comment.id AS comment_id," + 
			"	reservation_user_comment.product_id AS product_id," + 
			"	reservation_user_comment.reservation_info_id AS reservation_info_id," + 
			"	reservation_user_comment.score AS score," + 
			"	reservation_user_comment.comment AS comment," + 
			"	reservation_info.reservation_name AS reservation_name," + 
			"	reservation_info.reservation_tel AS reservation_telephone," + 
			"	reservation_info.reservation_email AS reservation_email," + 
			"	reservation_info.reservation_date AS reservation_date," + 
			"	reservation_user_comment.create_date AS create_date," + 
			"	reservation_user_comment.modify_date AS modify_date," + 
			"	display_info_image.id AS image_id," +
			"	reservation_user_comment_image.reservation_info_id AS reservation_info_id," + 
			"	reservation_user_comment_image.reservation_user_comment_id AS reservation_user_comment_id," + 
			"	file_info.id AS file_id," + 
			"	file_info.file_name AS file_name," + 
			"	file_info.save_file_name AS save_file_name," + 
			"	file_info.content_type AS content_type," + 
			"	file_info.delete_flag AS delete_flag," + 
			"	file_info.create_date AS create_date," + 
			"	file_info.modify_date AS modify_date " + 
			"FROM" + 
			"	reservation_user_comment " + 
			"INNER JOIN" + 
			"	reservation_info " + 
			"ON" + 
			"	reservation_user_comment.reservation_info_id = reservation_info.id " + 
			"LEFT JOIN" + 
			"	reservation_user_comment_image " + 
			"ON" + 
			"	reservation_user_comment_image.reservation_info_id = reservation_user_comment.reservation_info_id " + 
			"LEFT JOIN" + 
			"	file_info " + 
			"ON" + 
			"	reservation_user_comment_image.file_id = file_info.id " + 
			"LEFT JOIN" + 
			"	display_info_image " + 
			"ON" + 
			"	file_info.id = display_info_image.file_id";
	
//	public static final String SELECT_COMMENT_API_WITH_COMMENTS = 
//			"SELECT * " + 
//			"FROM (" + 
//			SELECT_COMMENT_API	 + 
//			") AS joined1 " + 
//			"LEFT OUTER JOIN " + 
//			"(" + 
//			CommentImageApiDaoSqls.SELECT_COMMENT_IMAGE_API + 
//			") AS comment_images " + 
//			"ON joined1.reservation_info_id = comment_images.reservation_info_id";
	
//	public static final String SELECT_COMMENT_API_WITH_COMMENTS = 
//			"SELECT * " + 
//			"FROM (" + 
//			SELECT_COMMENT_API	 + 
//			") AS joined1 " + 
//			"LEFT OUTER JOIN " + 
//			"(" + 
//			CommentImageApiDaoSqls.SELECT_COMMENT_IMAGE_API + 
//			") AS comment_images " + 
//			"ON joined1.reservation_info_id = comment_images.reservation_info_id";

	
}
