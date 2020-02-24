package com.naver.booking.dao;

public class CommentDaoSqls {
	
	public static final String SELECT_THREE_COMMENT = 
			"SELECT" + 
			"	reservation_user_comment.id AS comment_id," + 		
			"	reservation_user_comment.comment AS comment," + 
			"	file_info.save_file_name AS save_file_name," + 
			"	reservation_info.reservation_email AS reservation_email," + 
			"	reservation_user_comment.score AS score," + 
			"	reservation_info.reservation_date AS reservation_date " + 
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
			"	file_info.id = display_info_image.file_id " +
			"WHERE" +
			"	reservation_user_comment.product_id = :productId " +
			"ORDER BY" +
			"	comment_id DESC " +
			"LIMIT :limit";
	
	public static final String SELECT_AVERAGE_SCORE = 
			"SELECT" +
			"	AVG(score) " +
			"FROM" +
			"	reservation_user_comment " +
			"WHERE " +
			"	product_id = :productId";
}
