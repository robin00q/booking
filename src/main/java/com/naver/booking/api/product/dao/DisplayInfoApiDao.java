package com.naver.booking.api.product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.booking.api.product.dto.DisplayInfoApiDto;
import com.naver.booking.util.TimeFormatter;

@Repository
public class DisplayInfoApiDao {

	private NamedParameterJdbcTemplate jdbc;
	
	public DisplayInfoApiDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public DisplayInfoApiDto selectDisplayInfoApi(long displayInfoId) {
		Map<String, Long> params = Collections.singletonMap("displayInfoId", displayInfoId);
		return jdbc.queryForObject(DisplayInfoApiDaoSqls.SELECT_DISPLAY_INFO_API, params, new RowMapper<DisplayInfoApiDto>() {

			@Override
			public DisplayInfoApiDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				DisplayInfoApiDto displayInfoDto = new DisplayInfoApiDto();
				
				displayInfoDto.setProductId(rs.getInt("product_id"));
				displayInfoDto.setCategoryId(rs.getInt("category_id"));
				displayInfoDto.setDisplayInfoId(rs.getInt("display_info_id"));
				displayInfoDto.setCategoryName(rs.getString("category_name"));
				displayInfoDto.setProductDescription(rs.getString("product_description"));
				displayInfoDto.setProductContent(rs.getString("product_content"));
				displayInfoDto.setProductEvent(rs.getString("product_event"));
				displayInfoDto.setOpeningHours(rs.getString("opening_hours"));
				displayInfoDto.setPlaceName(rs.getString("place_name"));
				displayInfoDto.setPlaceLot(rs.getString("place_lot"));
				displayInfoDto.setPlaceStreet(rs.getString("place_street"));
				displayInfoDto.setTelephone(rs.getString("telephone"));
				displayInfoDto.setHomepage(rs.getString("homepage"));
				displayInfoDto.setEmail(rs.getString("email"));
				displayInfoDto.setCreateDate(TimeFormatter.DateToLocalDateTime(rs.getTimestamp("create_date")));
				displayInfoDto.setModifyDate(TimeFormatter.DateToLocalDateTime(rs.getTimestamp("modify_date")));
				
				return displayInfoDto;
			}
			
		});
	}
	
}
