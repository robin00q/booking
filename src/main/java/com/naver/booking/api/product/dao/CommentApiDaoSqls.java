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
			"SELECT * " + 
			"FROM (" + 
			SELECT_COMMENT_API	 + 
			") AS joined1 " + 
			"LEFT OUTER JOIN " + 
			"(" + 
			CommentImageApiDaoSqls.SELECT_COMMENT_IMAGE_API + 
			") AS comment_images " + 
			"ON joined1.reservation_info_id = comment_images.reservation_info_id";

	
}
