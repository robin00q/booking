package com.naver.booking.api.product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.booking.api.product.dto.DisplayInfoImageApiDto;
import com.naver.booking.util.TimeFormatter;

@Repository
public class DisplayInfoImageApiDao {

	private NamedParameterJdbcTemplate jdbc;
	
	public DisplayInfoImageApiDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public DisplayInfoImageApiDto selectDisplayInfoImageApi(long displayInfoId) {
		Map<String, Long> params = Collections.singletonMap("displayInfoId", displayInfoId);
		return jdbc.queryForObject(DisplayInfoImageApiDaoSqls.SELECT_DISPLAY_INFO_IMAGE_API, params ,new RowMapper<DisplayInfoImageApiDto>() {
			@Override
			public DisplayInfoImageApiDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				DisplayInfoImageApiDto displayInfoImageApiDto = new DisplayInfoImageApiDto();
				
				displayInfoImageApiDto.setDisplayInfoImageId(rs.getInt("display_info_image_id"));
				displayInfoImageApiDto.setDisplayInfoId(rs.getInt("display_info_id"));
				displayInfoImageApiDto.setFileId(rs.getInt("file_id"));
				displayInfoImageApiDto.setFileName(rs.getString("file_name"));
				displayInfoImageApiDto.setSaveFileName(rs.getString("save_file_name"));
				displayInfoImageApiDto.setContentType(rs.getString("content_type"));
				displayInfoImageApiDto.setDeleteFlag(rs.getBoolean("delete_flag"));
				displayInfoImageApiDto.setCreateDate(TimeFormatter.DateToLocalDateTime(rs.getTimestamp("create_date")));
				displayInfoImageApiDto.setModifyDate(TimeFormatter.DateToLocalDateTime(rs.getTimestamp("modify_date")));
				
				return displayInfoImageApiDto;
			}
			
		});
	}
}
