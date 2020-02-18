package com.naver.booking.api.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.booking.api.dto.ProductImageApiDto;

@Repository
public class ProductImageApiDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ProductImageApiDto> rowMapper = BeanPropertyRowMapper.newInstance(ProductImageApiDto.class);
	
	public ProductImageApiDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ProductImageApiDto> selectProductImageApi(Long productId){
		Map<String, Long> params = Collections.singletonMap("productId", productId);
		return jdbc.query(ProductImageApiDaoSqls.SELECT_PRODUCT_IMAGE_API, params, rowMapper);
	}
	
}
