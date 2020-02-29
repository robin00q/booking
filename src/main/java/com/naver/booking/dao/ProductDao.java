package com.naver.booking.dao;

import java.util.Collections;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.booking.dto.ProductDto;

@Repository
public class ProductDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ProductDto> rowMapper = BeanPropertyRowMapper.newInstance(ProductDto.class);

	public ProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public ProductDto selectProductByDisplayInfoId(long displayInfoId) {
		Map<String, Long> params = Collections.singletonMap("displayInfoId", displayInfoId);
		return jdbc.queryForObject(ProductDaoSqls.SELECT_PRODUCT_BY_DISPLAY_INFO_ID, params, rowMapper);
	}

}
