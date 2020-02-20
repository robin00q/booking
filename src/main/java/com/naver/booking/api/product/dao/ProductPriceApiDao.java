package com.naver.booking.api.product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.booking.api.product.dto.ProductPriceApiDto;
import com.naver.booking.util.TimeFormatter;

@Repository
public class ProductPriceApiDao {

	private NamedParameterJdbcTemplate jdbc;
	
	public ProductPriceApiDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ProductPriceApiDto> SelectProductPriceApi(Long productId){
		Map<String, Long> params = Collections.singletonMap("productId", productId);
		return jdbc.query(ProductPriceApiDaoSqls.SELECT_PRODUCT_PRICE_API, params, new RowMapper<ProductPriceApiDto>() {
			@Override
			public ProductPriceApiDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductPriceApiDto productPriceApiDto = new ProductPriceApiDto();
				
				productPriceApiDto.setProductPriceId(rs.getInt("product_price_id"));
				productPriceApiDto.setProductId(rs.getInt("product_id"));
				productPriceApiDto.setPriceTypeName(rs.getString("price_type_name"));
				productPriceApiDto.setPrice(rs.getInt("price"));
				productPriceApiDto.setDiscountRate(rs.getInt("discount_rate"));
				productPriceApiDto.setCreateDate(TimeFormatter.DateToLocalDateTime(rs.getTimestamp("create_date")));
				productPriceApiDto.setModifyDate(TimeFormatter.DateToLocalDateTime(rs.getTimestamp("modify_date")));
				
				return productPriceApiDto;
			}
			
		});
	}
}
