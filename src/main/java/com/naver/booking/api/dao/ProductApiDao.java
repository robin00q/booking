package com.naver.booking.api.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.booking.api.dto.ProductApiDto;

@Repository
public class ProductApiDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ProductApiDto> rowMapper = BeanPropertyRowMapper.newInstance(ProductApiDto.class);
	
	public ProductApiDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ProductApiDto> SelectProductsApi(int categoryId, int start){
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		return jdbc.query(ProductApiDaoSqls.SELECT_PRODUCTS_API, params, rowMapper);
	}
	
	public int SelectProductCountByCategory(int categoryId) {
		Map<String, Integer> params = Collections.singletonMap("categoryId", categoryId);
		return jdbc.queryForObject(ProductApiDaoSqls.SELECT_PRODUCT_COUNT_BY_CATEGORY, params, Integer.class);
		
	}
}
