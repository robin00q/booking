package com.naver.booking.api.dao;

public class DisplayInfoApiDaoSqls {

	public static final String SELECT_PRODUCT_AND_CATEGORY_NAME = 
			"SELECT product.id AS product_id, category.name AS category_name, product.description AS product_description, product.content AS product_content, product.event AS product_event "
			+ "FROM product "
			+ "INNER JOIN category "
			+ "ON category.id = product.category_id";
}

//productId, categoryName, desc, content, event