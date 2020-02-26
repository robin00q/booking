package com.naver.booking.dao;

public class ProductDaoSqls {

	public static final String SELECT_PRODUCT_BY_PRODUCT_ID = 
			"SELECT" +
			"	id," +
			"	description,"+
			"	content " +
			"FROM" +
			"	product " +
			"WHERE " +
			"	id = :productId";
}
