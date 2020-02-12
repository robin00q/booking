package com.naver.booking.dao;

import java.util.Collections;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DisplayInfoDao {

	private NamedParameterJdbcTemplate jdbc;
	
	public DisplayInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public int selectDisplayInfoTotalCount() {
		return jdbc.queryForObject(DisplayInfoDaoSqls.SELECT_DISPLAY_INFO_TOTAL_COUNT, Collections.emptyMap(), Integer.class);
	}
}
