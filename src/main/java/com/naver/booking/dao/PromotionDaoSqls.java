package com.naver.booking.dao;

public class PromotionDaoSqls {

	public static final String SELECT_PROMOTION_INFORMATION = 
			"SELECT joined.id, joined.product_id, file_info.save_file_name " + 
			"FROM file_info " + 
			"INNER JOIN " + 
			"(" + 
			"select promotion.id, promotion.product_id, product_image.file_id from promotion inner join product_image where promotion.product_id = product_image.product_id and type='th'" + 
			") AS joined ON file_info.id = joined.file_id";
}
