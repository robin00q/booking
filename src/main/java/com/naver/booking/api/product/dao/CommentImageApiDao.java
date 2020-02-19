package com.naver.booking.api.product.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.booking.api.product.dto.CommentImageApiDto;

@Repository
public class CommentImageApiDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<CommentImageApiDto> rowMapper = BeanPropertyRowMapper.newInstance(CommentImageApiDto.class);

	public CommentImageApiDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<CommentImageApiDto> selectCommentImageApi(){
		return jdbc.query(CommentImageApiDaoSqls.SELECT_COMMENT_IMAGE_API, rowMapper);
	}
}
