package com.naver.booking.dao;

import java.util.Collections;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.booking.dto.DisplayInfoDto;

@Repository
public class DisplayInfoDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<DisplayInfoDto> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoDto.class);
	
	public DisplayInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public DisplayInfoDto selectDisplayInfoSaveFileName(Long productId) {
		Map<String, Long> params = Collections.singletonMap("productId",  productId);
		return jdbc.queryForObject(DisplayInfoDaoSqls.SELECT_DISPLAY_INFO, params, rowMapper);
	}
}
