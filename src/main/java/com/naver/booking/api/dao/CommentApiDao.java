package com.naver.booking.api.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.booking.api.dto.CommentApiDto;

@Repository
public class CommentApiDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<CommentApiDto> rowMapper = BeanPropertyRowMapper.newInstance(CommentApiDto.class);

	public CommentApiDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<CommentApiDto> SelectCommentApi(){
		return jdbc.query(CommentApiDaoSqls.SELECT_COMMENT_API, rowMapper);
	}
	
	public List<CommentApiDto> SelectCommentApiWithComments(){
		return jdbc.query(CommentApiDaoSqls.SELECT_COMMENT_API_WITH_COMMENTS, rowMapper);
	}
}
