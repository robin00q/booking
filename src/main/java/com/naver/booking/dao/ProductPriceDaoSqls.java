package com.naver.booking.dao;

public class ProductPriceDaoSqls {

	public static final String SELECT_PRODUCT_PRICE_BY_PRODUCT_ID = 
			"SELECT" +
			"	id," +
			"	product_id,"+
			"	price_type_name," +
			"	price," +
			"	discount_rate " +	
			"FROM" +
			"	product_price " +
			"WHERE " +
			"	product_id = :productId";
}
