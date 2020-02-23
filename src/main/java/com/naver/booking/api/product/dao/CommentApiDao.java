package com.naver.booking.api.product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.booking.api.product.dto.CommentApiDto;
import com.naver.booking.api.product.dto.CommentImageApiDto;
import com.naver.booking.util.TimeFormatter;

@Repository
public class CommentApiDao {

	private NamedParameterJdbcTemplate jdbc;

	public CommentApiDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<CommentApiDto> SelectCommentApiWithComments(Long productId){
		Map<String, Long> params = Collections.singletonMap("productId", productId);
		return jdbc.query(CommentApiDaoSqls.SELECT_COMMENT_API_WITH_COMMENTS, params, new ResultSetExtractor<List<CommentApiDto>>() {

			@Override
			public List<CommentApiDto> extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				Map<Integer, CommentApiDto> commentApiDtoMap = new HashMap<Integer, CommentApiDto>();
				
				while(rs.next()) {
					Integer reservationInfoId = rs.getInt("reservation_info_id");
					
					CommentApiDto commentApiDto = commentApiDtoMap.get(reservationInfoId);
					
					
					if(commentApiDto == null) {
						commentApiDto = new CommentApiDto();
						
						commentApiDto.setCommentId(rs.getInt("comment_id"));
						commentApiDto.setProductId(rs.getInt("product_id"));
						commentApiDto.setReservationInfoId(rs.getInt("reservation_info_id"));
						commentApiDto.setScore(rs.getInt("score"));
						commentApiDto.setComment(rs.getString("comment"));
						commentApiDto.setReservationName(rs.getString("reservation_name"));
						commentApiDto.setReservationTelephone(rs.getString("reservation_telephone"));
						commentApiDto.setReservationEmail(rs.getString("reservation_email"));
						commentApiDto.setReservationDate(TimeFormatter.DateToLocalDateTime(rs.getTimestamp("reservation_date")));
						commentApiDto.setCreateDate(TimeFormatter.DateToLocalDateTime(rs.getTimestamp("create_date")));
						commentApiDto.setModifyDate(TimeFormatter.DateToLocalDateTime(rs.getTimestamp("modify_date")));
						
						commentApiDtoMap.put(reservationInfoId, commentApiDto);
					} 
					
					if(rs.getInt("comment_images_image_id") != 0) {
						CommentImageApiDto commentImageApiDto = new CommentImageApiDto();
						
						commentImageApiDto.setImageId(rs.getInt("comment_images_image_id"));
						commentImageApiDto.setReservationInfoId(rs.getInt("comment_images_reservation_info_id"));
						commentImageApiDto.setReservationUserCommentId(rs.getInt("comment_images_reservation_user_comment_id"));
						commentImageApiDto.setFileId(rs.getInt("comment_images_file_id"));
						commentImageApiDto.setFileName(rs.getString("comment_images_file_name"));
						commentImageApiDto.setSaveFileName(rs.getString("comment_images_save_file_name"));
						commentImageApiDto.setContentType(rs.getString("comment_images_content_type"));
						commentImageApiDto.setDeleteFlag(rs.getBoolean("comment_images_delete_flag"));
						commentImageApiDto.setCreateDate(TimeFormatter.DateToLocalDateTime(rs.getTimestamp("comment_images_create_date")));
						commentImageApiDto.setModifyDate(TimeFormatter.DateToLocalDateTime(rs.getTimestamp("comment_images_modify_date")));
						
						commentApiDto.addCommentImages(commentImageApiDto);
					}
					
				}
			
				List<CommentApiDto> commentApiDtoArrayList = new ArrayList<CommentApiDto>(commentApiDtoMap.values());
				Collections.reverse(commentApiDtoArrayList);
				
				return commentApiDtoArrayList;
			}
			
		});
	}
}
