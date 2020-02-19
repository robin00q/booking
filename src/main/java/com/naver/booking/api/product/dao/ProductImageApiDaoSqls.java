package com.naver.booking.api.product.dao;

public class ProductImageApiDaoSqls {
	
	public static final String SELECT_PRODUCT_IMAGE_API = 
			"SELECT " + 
			"product_image.product_id as product_id, " + 
			"product_image.id as product_image_id, " + 
			"product_image.type as type, " + 
			"file_info.id as file_info_id, " + 
			"file_info.file_name as file_name, " + 
			"file_info.save_file_name as save_file_name, " + 
			"file_info.content_type as content_type, " + 
			"file_info.delete_flag as delete_flag, " + 
			"file_info.create_date as create_date, " + 
			"file_info.modify_date as modify_date " + 
			"FROM product_image " + 
			"INNER JOIN file_info " + 
			"ON product_image.file_id = file_info.id " + 
			"WHERE product_image.product_id = :productId AND type != 'th' " + 
			"ORDER BY type desc " + 
			"LIMIT 2";
}
