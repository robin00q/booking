package com.naver.booking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.booking.dto.CommentDto;
import com.naver.booking.util.TimeFormatter;

@Repository
public class CommentDao {

	private NamedParameterJdbcTemplate jdbc;

	public CommentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<CommentDto> selectThreeComent(long productId){
		Map<String, Object> params = new HashMap<>();
		params.put("productId", productId);
		params.put("limit", 3);
		
		return jdbc.query(CommentDaoSqls.SELECT_THREE_COMMENT, params, new RowMapper<CommentDto>(){

			@Override
			public CommentDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				CommentDto commentDto = new CommentDto();
				
				commentDto.setComment(rs.getString("comment"));
				commentDto.setSaveFileName(rs.getString("save_file_name"));
				commentDto.setReservationEmail(rs.getString("reservation_email"));
				commentDto.setScore(rs.getDouble("score"));
				commentDto.setReservationDate(TimeFormatter.DateToLocalDateTime(rs.getTimestamp("reservation_date")));
				
				return commentDto;
			}
			
		});
	}
	
	public List<CommentDto> selectComment(long productId){
		Map<String, Object> params = Collections.singletonMap("productId",  productId);
		
		return jdbc.query(CommentDaoSqls.SELECT_COMMENT, params, new RowMapper<CommentDto>(){

			@Override
			public CommentDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				CommentDto commentDto = new CommentDto();
				
				commentDto.setComment(rs.getString("comment"));
				commentDto.setSaveFileName(rs.getString("save_file_name"));
				commentDto.setReservationEmail(rs.getString("reservation_email"));
				commentDto.setScore(rs.getDouble("score"));
				commentDto.setReservationDate(TimeFormatter.DateToLocalDateTime(rs.getTimestamp("reservation_date")));
				
				return commentDto;
			}
			
		});
	}
	
	public Double selectAverageScore(long productId) {
		Map<String, Object> params = Collections.singletonMap("productId",  productId);
		return jdbc.queryForObject(CommentDaoSqls.SELECT_AVERAGE_SCORE, params, Double.class);
	}
	
	public String selectDescriptionByProductId(long productId) {
		Map<String, Object> params = Collections.singletonMap("productId",  productId);
		return jdbc.queryForObject(CommentDaoSqls.SELECT_DESCRIPTION_BY_PRODUCT_ID, params, String.class);
	}
}
