package com.naver.booking.api.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.booking.api.dto.ProductPriceApiDto;

@Repository
public class ProductPriceApiDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ProductPriceApiDto> rowMapper = BeanPropertyRowMapper.newInstance(ProductPriceApiDto.class);
	
	public ProductPriceApiDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ProductPriceApiDto> SelectProductPriceApi(Long productId){
		Map<String, Long> params = Collections.singletonMap("productId", productId);
		return jdbc.query(ProductPriceApiDaoSqls.SELECT_PRODUCT_PRICE_API, params, rowMapper);
	}
}
