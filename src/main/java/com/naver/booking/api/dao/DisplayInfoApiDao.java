package com.naver.booking.api.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.booking.api.dto.DisplayInfoApiDto;

@Repository
public class DisplayInfoApiDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<DisplayInfoApiDto> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoApiDto.class);
	
	public DisplayInfoApiDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public DisplayInfoApiDto selectDisplayInfoApi() {
		
		return null;
	}
	
}
