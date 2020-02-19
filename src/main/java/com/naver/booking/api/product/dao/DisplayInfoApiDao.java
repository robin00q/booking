package com.naver.booking.api.product.dao;

import java.util.Collections;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.booking.api.product.dto.DisplayInfoApiDto;

@Repository
public class DisplayInfoApiDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<DisplayInfoApiDto> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoApiDto.class);
	
	public DisplayInfoApiDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public DisplayInfoApiDto selectDisplayInfoApi(long displayInfoId) {
		Map<String, Long> params = Collections.singletonMap("displayInfoId", displayInfoId);
		return jdbc.queryForObject(DisplayInfoApiDaoSqls.SELECT_DISPLAY_INFO_API, params, rowMapper);
	}
	
}
