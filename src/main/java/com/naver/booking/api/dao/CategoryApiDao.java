package com.naver.booking.api.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.booking.api.dto.CategoryApiDto;

@Repository
public class CategoryApiDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<CategoryApiDto> rowMapper = BeanPropertyRowMapper.newInstance(CategoryApiDto.class);

	public CategoryApiDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<CategoryApiDto> selectCategoriesApi() {
		return jdbc.query(CategoryApiDaoSqls.SELECT_CATEGORIES_API, rowMapper);
	}
}
