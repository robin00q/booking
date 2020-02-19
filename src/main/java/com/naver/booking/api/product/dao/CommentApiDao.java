package com.naver.booking.api.product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.booking.api.product.dto.CommentApiDto;
import com.naver.booking.api.product.dto.CommentImageApiDto;

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
		return jdbc.query(CommentApiDaoSqls.SELECT_COMMENT_API_WITH_COMMENTS, new ResultSetExtractor<List<CommentApiDto>>() {

			@Override
			public List<CommentApiDto> extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				Map<Integer, CommentApiDto> commentApiDtoMap = new HashMap<Integer, CommentApiDto>();
				
				while(rs.next()) {
					Integer reservationInfoId = rs.getInt("reservation_info_id");
					
					System.out.println(reservationInfoId);
					
					CommentApiDto commentApiDto = commentApiDtoMap.get(reservationInfoId);
					
					
					if(commentApiDto == null) {
						commentApiDto = new CommentApiDto();
						commentApiDto.setReservationInfoId(reservationInfoId);
						commentApiDtoMap.put(reservationInfoId, commentApiDto);
						System.out.println(commentApiDto.toString());
					} 
					
					CommentImageApiDto commentImageApiDto = new CommentImageApiDto();
					commentImageApiDto.setImageId(rs.getInt("image_id"));
					commentImageApiDto.setReservationInfoId(rs.getInt("reservation_info_id"));
					commentImageApiDto.setReservationUserCommentId(rs.getInt("reservation_user_comment_id"));
					commentImageApiDto.setFileId(rs.getInt("file_id"));
					commentImageApiDto.setFileName(rs.getString("save_file_name"));
					commentApiDto.setCommentImages(commentImageApiDto);
				}
				
				return new ArrayList<CommentApiDto>(commentApiDtoMap.values());
			}
			
		});
	}
}
