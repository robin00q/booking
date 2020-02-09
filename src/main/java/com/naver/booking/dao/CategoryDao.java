package com.naver.booking.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.booking.dto.CategoryApiDto;

@Repository
public class CategoryDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<CategoryApiDto> rowMapper = BeanPropertyRowMapper.newInstance(CategoryApiDto.class);

	public CategoryDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<CategoryApiDto> selectCategoriesIdNameCount() {
		return jdbc.query(CategoryDaoSqls.SELECT_CATEGORIES_ID_NAME_COUNT, rowMapper);
	}
}
