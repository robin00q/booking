package com.naver.booking.dao;

public class ProductPriceDaoSqls {

	public static final String SELECT_PRODUCT_PRICE_BY_PRODUCT_ID = 
			"SELECT" +
			"	product_price.id AS product_price_id," +
			"	product_id,"+
			"	price_type_name," +
			"	price," +
			"	discount_rate " +	
			"FROM" +
			"	product_price " +
			"WHERE " +
			"	product_id = :productId " +
			"ORDER BY" + 
			"	price " +
			"DESC";
}
