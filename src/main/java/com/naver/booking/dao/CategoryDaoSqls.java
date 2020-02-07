package com.naver.booking.dao;

public class CategoryDaoSqls {

//	public static final String SELECT_CATEGORIES_ID_NAME_COUNT = 
//			"SELECT category.id, category.name, COUNT(product.category_id) AS count "
//			+ "FROM category "
//			+ "INNER JOIN product ON category.id = product.category_id "
//			+ "GROUP BY category.id";
	
	public static final String SELECT_CATEGORIES_COUNT = 
			"SELECT product.category_id, display_info.product_id "
			+ "FROM product "
			+ "INNER JOIN display_info "
			+ "ON product.id = display_info.product_id";
	
	public static final String SELECT_CATEGORIES_ID_NAME_COUNT = 
			"SELECT category.id, category.name, count(category.id) AS count "
			+ "FROM category "
			+ "INNER JOIN ("
			+ SELECT_CATEGORIES_COUNT
			+ ") AS joined "
			+ "ON category.id = joined.category_id "
			+ "GROUP BY category.id";
}
