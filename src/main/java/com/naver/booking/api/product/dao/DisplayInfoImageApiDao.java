package com.naver.booking.api.product.dao;

import java.util.Collections;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.booking.api.product.dto.DisplayInfoImageApiDto;

@Repository
public class DisplayInfoImageApiDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<DisplayInfoImageApiDto> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoImageApiDto.class);
	
	public DisplayInfoImageApiDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public DisplayInfoImageApiDto selectDisplayInfoImageApi(long displayInfoId) {
		Map<String, Long> params = Collections.singletonMap("displayInfoId", displayInfoId);
		return jdbc.queryForObject(DisplayInfoImageApiDaoSqls.SELECT_DISPLAY_INFO_IMAGE_API, params ,rowMapper);
	}
}
