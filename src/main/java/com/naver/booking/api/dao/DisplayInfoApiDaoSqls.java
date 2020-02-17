package com.naver.booking.api.dao;

public class DisplayInfoApiDaoSqls {
	
	public static final String SELECT_PRODUCT_AND_CATEGORY_NAME = 
			"SELECT "
			+ "category.id AS category_id, "
			+ "product.id AS product_id, "
			+ "category.name AS category_name, "
			+ "product.description AS product_description, "
			+ "product.content AS product_content, "
			+ "product.event AS product_event "
			+ "FROM product "
			+ "INNER JOIN category "
			+ "ON category.id = product.category_id";
	
	public static final String SELECT_DISPLAY_INFO_API = 
			"SELECT " + 
			"joined.product_id AS product_id, " + 
			"joined.category_id AS category_id, " + 
			"display_info.id AS display_info_id, " + 
			"joined.category_name AS category_name, " + 
			"joined.product_description AS product_description, " + 
			"joined.product_content AS product_content, " + 
			"joined.product_event AS product_event, " + 
			"display_info.opening_hours AS opening_hours," + 
			"display_info.place_name AS place_name, " + 
			"display_info.place_lot AS place_lot, " + 
			"display_info.place_street AS place_street, " + 
			"display_info.tel AS telephone, " + 
			"display_info.homepage AS homepage, " + 
			"display_info.email AS email, " + 
			"display_info.create_date AS create_date, " + 
			"display_info.modify_date AS modify_date " + 			
			"FROM display_info " + 
			"INNER JOIN (" + 
			SELECT_PRODUCT_AND_CATEGORY_NAME + 
			") AS joined " + 
			"ON joined.product_id = display_info.product_id "+ 
			"WHERE display_info.id = :displayInfoId";

	
}

//productId, categoryName, desc, content, event