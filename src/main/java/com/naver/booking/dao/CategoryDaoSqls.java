package com.naver.booking.dao;

public class CategoryDaoSqls {

	public static final String SELECT_CATEGORIES_ID_NAME_COUNT = 
			"SELECT category.id, category.name, COUNT(product.category_id) AS count "
			+ "FROM category "
			+ "INNER JOIN product ON category.id = product.category_id "
			+ "GROUP BY category.id";
}
