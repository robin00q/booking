package com.naver.booking.api.product.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.booking.api.product.dto.ProductApiDto;

@Repository
public class ProductApiDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ProductApiDto> rowMapper = BeanPropertyRowMapper.newInstance(ProductApiDto.class);
	
	public ProductApiDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ProductApiDto> SelectProductsApi(Long categoryId, Long start){
		Map<String, Long> params = new HashMap<>();
		params.put("start", start);
		if(categoryId == 0) {
			return jdbc.query(ProductApiDaoSqls.SELECT_ALL_PRODUCTS_API, params, rowMapper);			
		}
		params.put("categoryId", categoryId);
		return jdbc.query(ProductApiDaoSqls.SELECT_PRODUCTS_API, params, rowMapper);
	}
	
	public Long SelectProductCountByCategory(Long categoryId) {
		if(categoryId == 0) {
			return jdbc.queryForObject(ProductApiDaoSqls.SELECT_ALL_PRODUCT_COUNT_BY_CATEGORY, Collections.emptyMap(), Long.class);
		}
		Map<String, Long> params = Collections.singletonMap("categoryId", categoryId);
		return jdbc.queryForObject(ProductApiDaoSqls.SELECT_PRODUCT_COUNT_BY_CATEGORY, params, Long.class);
		
	}
}
