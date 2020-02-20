package com.naver.booking.api.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naver.booking.api.product.dao.CommentImageApiDao;
import com.naver.booking.api.product.dto.CommentImageApiDto;
import com.naver.booking.config.ApplicationConfiguration;

class CommentImageApiDaoTest {
	@Autowired
	ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
	
	CommentImageApiDao commentImageApiDao = ac.getBean(CommentImageApiDao.class);
	
	@Test
	void testSelectCommentImageApi() {
		
		List<CommentImageApiDto> commentImageApiDtoList = commentImageApiDao.selectCommentImageApi();
		
		for (CommentImageApiDto commentImageApiDto : commentImageApiDtoList) {
			System.out.println(commentImageApiDto);
		}
		
		assertNotNull(commentImageApiDtoList);
	}

}
