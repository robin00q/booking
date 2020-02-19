package com.naver.booking.api.promotion.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.booking.api.promotion.dto.PromotionApiDto;

@Repository
public class PromotionApiDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<PromotionApiDto> rowMapper = BeanPropertyRowMapper.newInstance(PromotionApiDto.class);
	
	public PromotionApiDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<PromotionApiDto> selectPromotionsApi(){
		return jdbc.query(PromotionApiDaoSqls.SELECT_PROMOTIONS_API, rowMapper);
	}
	
}
