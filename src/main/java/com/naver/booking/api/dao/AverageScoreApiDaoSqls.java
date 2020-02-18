package com.naver.booking.api.dao;

public class AverageScoreApiDaoSqls {

	public static final String SELECT_RESERVATION_USER_COMMENT_AVERAGE_SCORE = 
			"SELECT AVG(score) " + 
			"FROM reservation_user_comment " + 
			"WHERE product_id = :productId";
}
