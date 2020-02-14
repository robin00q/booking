package com.naver.booking.api.dao;

public class ProductApiDaoSqls {

	public static final String SELECT_PRODUCT_IMAGE_FILE_INFO_FROM_PRODUCT_IMAGE_JOIN_FILE_INFO = 
			"SELECT product_image.product_id, product_image.type, file_info.save_file_name "
			+ "FROM product_image "
			+ "INNER JOIN file_info "
			+ "WHERE product_image.file_id = file_info.id";
	
	public static final String SELECT_PRODUCT_INFORMATION_FROM_PRODUCT_JOIN_PRODUCT_IMAGE_FILE_INFO = 
			"SELECT product.id, product.category_id, product.description, product.content, product_info.save_file_name "
			+ "FROM product "
			+ "INNER JOIN ("
			+ SELECT_PRODUCT_IMAGE_FILE_INFO_FROM_PRODUCT_IMAGE_JOIN_FILE_INFO
			+ ") as product_info "
			+ "ON product.id = product_info.product_id "
			+ "WHERE product_info.type = 'th'";
	
	public static final String SELECT_PRODUCTS_API = 
			"SELECT display_info.id AS display_info_id, product_desc.id AS product_id, product_desc.description AS product_description, display_info.place_name AS place_name, product_desc.content AS product_content, product_desc.save_file_name AS product_image_url "
			+ "FROM display_info "
			+ "INNER JOIN ("
			+ SELECT_PRODUCT_INFORMATION_FROM_PRODUCT_JOIN_PRODUCT_IMAGE_FILE_INFO
			+ ") as product_desc "
			+ "ON product_desc.id = display_info.product_id "
			+ "WHERE product_desc.category_id = :categoryId limit :start, 4";
	
	public static final String SELECT_ALL_PRODUCTS_API = 
			"SELECT display_info.id AS display_info_id, product_desc.id AS product_id, product_desc.description AS product_description, display_info.place_name AS place_name, product_desc.content AS product_content, product_desc.save_file_name AS product_image_url "
			+ "FROM display_info "
			+ "INNER JOIN ("
			+ SELECT_PRODUCT_INFORMATION_FROM_PRODUCT_JOIN_PRODUCT_IMAGE_FILE_INFO
			+ ") as product_desc "
			+ "ON product_desc.id = display_info.product_id "
			+ "limit :start, 4";
	
	public static final String SELECT_PRODUCT_COUNT_BY_CATEGORY = 
			"SELECT count(product.category_id) "
			+ "FROM product "
			+ "INNER JOIN display_info "
			+ "ON product.id = display_info.product_id "
			+ "WHERE product.category_id = :categoryId "
			+ "GROUP BY product.category_id";
	
	public static final String SELECT_ALL_PRODUCT_COUNT_BY_CATEGORY = 
			"SELECT COUNT(*)"
			+ "FROM display_info";
	
}
