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

import com.naver.booking.api.product.dto.ProductImageApiDto;
import com.naver.booking.util.TimeFormatter;

@Repository
public class ProductImageApiDao {

	private NamedParameterJdbcTemplate jdbc;
	
	public ProductImageApiDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ProductImageApiDto> selectProductImageApi(Long productId){
		Map<String, Long> params = Collections.singletonMap("productId", productId);
		return jdbc.query(ProductImageApiDaoSqls.SELECT_PRODUCT_IMAGE_API, params, new RowMapper<ProductImageApiDto>() {

			@Override
			public ProductImageApiDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductImageApiDto productImageApiDto = new ProductImageApiDto();
				
				productImageApiDto.setProductId(rs.getInt("product_id"));
				productImageApiDto.setProductImageId(rs.getInt("product_image_id"));
				productImageApiDto.setType(rs.getString("type"));
				productImageApiDto.setFileInfoId(rs.getInt("file_info_id"));
				productImageApiDto.setFileName(rs.getString("file_name"));
				productImageApiDto.setSaveFileName(rs.getString("save_file_name"));
				productImageApiDto.setContentType(rs.getString("content_type"));
				productImageApiDto.setDeleteFlag(rs.getBoolean("delete_flag"));
				productImageApiDto.setCreateDate(TimeFormatter.DateToLocalDateTime(rs.getTimestamp("create_date")));
				productImageApiDto.setModifyDate(TimeFormatter.DateToLocalDateTime(rs.getTimestamp("modify_date")));
				
				return productImageApiDto;
			}
			
		});
	}
	
}
