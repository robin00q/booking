package com.naver.booking.dao;

import java.util.Collections;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DisplayInfoImageDao {

	private NamedParameterJdbcTemplate jdbc;
	
	public DisplayInfoImageDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public String selectDisplayInfoSaveFileName(Long productId) {
		Map<String, Long> params = Collections.singletonMap("productId",  productId);
		return jdbc.queryForObject(DisplayInfoImageDaoSqls.SELECT_DISPLAY_INFO_SAVE_FILE_NAME, params, String.class);
	}
}
