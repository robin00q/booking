package com.naver.booking.api.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naver.booking.api.product.dao.CommentApiDao;
import com.naver.booking.api.product.dto.CommentApiDto;
import com.naver.booking.config.ApplicationConfiguration;

class CommentApiDaoTest {
	
	@Autowired
	ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
	
	CommentApiDao commentApiDao = ac.getBean(CommentApiDao.class);

	@Test
	void testSelectCommentApi() {
		
		List<CommentApiDto> commentApiDtoList = commentApiDao.SelectCommentApi();
		
		for (CommentApiDto commentApiDto : commentApiDtoList) {
			System.out.println(commentApiDto);
		}
		
		assertNotNull(commentApiDtoList);
	}
	
//	@Test
//	void testSelectCommentApiWithComments() {
//		
//		List<CommentApiDto> commentApiDtoList = commentApiDao.SelectCommentApiWithComments();
//		
//		for (CommentApiDto commentApiDto : commentApiDtoList) {
//			System.out.println(commentApiDto);
//		}
//		
//		assertNotNull(commentApiDtoList);
//	}

}
