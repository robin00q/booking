package com.naver.booking.api.dao;

public class PromotionApiDaoSqls {

	public static final String SELECT_PROMOTIONS_ID_PRODUCT_ID_PRODUCT_IMAGE_FILE_ID = 
			"SELECT promotion.id, promotion.product_id, product_image.file_id "
					+ "FROM promotion "
					+ "INNER JOIN product_image "
					+ "WHERE promotion.product_id = product_image.product_id AND type='th'";

	public static final String SELECT_PROMOTIONS_API = 
			"SELECT joined.id, joined.product_id, file_info.save_file_name " + 
			"FROM file_info " + 
			"INNER JOIN " + 
			"(" + 
			SELECT_PROMOTIONS_ID_PRODUCT_ID_PRODUCT_IMAGE_FILE_ID + 
			") AS joined ON file_info.id = joined.file_id";
}
