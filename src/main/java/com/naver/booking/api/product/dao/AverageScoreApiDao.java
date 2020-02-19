package com.naver.booking.api.product.dao;

import java.util.Collections;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AverageScoreApiDao {

	private NamedParameterJdbcTemplate jdbc;
	
	public AverageScoreApiDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public double SelectReservationUserCommentAverageScore(Long productId) {
		Map<String, Long> params = Collections.singletonMap("productId", productId);
		return jdbc.queryForObject(AverageScoreApiDaoSqls.SELECT_RESERVATION_USER_COMMENT_AVERAGE_SCORE, params, Double.class);
	}
}
