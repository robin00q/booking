package com.naver.booking.dao;

public class ProductDaoSqls {

	public static final String SELECT_PRODUCT_BY_PRODUCT_ID = 
			"SELECT" +
			"	product.id AS id," +
			"	product.description AS description,"+
			"	product.content AS content," +
			"	display_info.id AS display_info_id " +	
			"FROM" +
			"	product " +
			"INNER JOIN" +
			"	display_info " +
			"ON" +
			"	product.id = display_info.product_id " +
			"WHERE " +
			"	display_info.id = :displayInfoId";
}
