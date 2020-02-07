package com.naver.booking.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.booking.dto.PromotionDto;

@Repository
public class PromotionDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<PromotionDto> rowMapper = BeanPropertyRowMapper.newInstance(PromotionDto.class);
	
	public PromotionDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<PromotionDto> selectPromotionsIdProductIdSaveFileName(){
		return jdbc.query(PromotionDaoSqls.SELECT_PROMOTIONS_ID_PRODUCT_ID_SAVE_FILE_NAME, rowMapper);
	}
	
}
