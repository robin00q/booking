package com.naver.booking.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.booking.dto.ProductApiDto;

@Repository
public class ProductDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ProductApiDto> rowMapper = BeanPropertyRowMapper.newInstance(ProductApiDto.class);
	
	public ProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ProductApiDto> SelectProductsDisplayInfoByCategoryId(int categoryId, int start){
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		return jdbc.query(ProductDaoSqls.SELECT_PRODUCT_DESCRIPTION_FROM_DISPLAY_INFO_JOIN_PRODUCT_INFORMATION, params, rowMapper);
	}
	
	public int SelectCategoryCountByCategoryId(int categoryId) {
		Map<String, Integer> params = Collections.singletonMap("categoryId", categoryId);
		return jdbc.queryForObject(ProductDaoSqls.SELECT_CATEGORY_COUNT, params, Integer.class);
		
	}
}
