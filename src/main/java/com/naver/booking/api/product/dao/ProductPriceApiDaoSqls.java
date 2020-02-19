package com.naver.booking.api.product.dao;

public class ProductPriceApiDaoSqls {

	public static final String SELECT_PRODUCT_PRICE_API = 
			"SELECT " + 
			"id AS product_price_id, " + 
			"product_id, " + 
			"price_type_name, " + 
			"price, " + 
			"discount_rate, " + 
			"create_date, " + 
			"modify_date " + 
			"FROM product_price " + 
			"WHERE product_id = :productId";
}
