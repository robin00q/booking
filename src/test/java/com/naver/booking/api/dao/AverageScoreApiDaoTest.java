package com.naver.booking.api.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naver.booking.config.ApplicationConfiguration;

class AverageScoreApiDaoTest {

	@Autowired
	ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
	
	AverageScoreApiDao averageScoreApiDao = ac.getBean(AverageScoreApiDao.class);
	
	@Test
	void testSelectReservationUserCommentAverageScore() {
		
		Long productId = (long) 1;
		
		double result = averageScoreApiDao.SelectReservationUserCommentAverageScore(productId);
		
		System.out.println(result);
		
		assertTrue(result != 0);
	}

}
