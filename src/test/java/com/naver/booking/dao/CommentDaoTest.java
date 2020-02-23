package com.naver.booking.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naver.booking.config.ApplicationConfiguration;
import com.naver.booking.dto.CommentDto;

class CommentDaoTest {

	@Autowired
	ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
	
	CommentDao commentDao = ac.getBean(CommentDao.class);
	
	@Test
	void testselectThreeComent() {
		long productId = 1;
		List<CommentDto> commentDtoList = commentDao.selectThreeComent(productId);
		
		for (CommentDto commentDto : commentDtoList) {
			System.out.println(commentDto);
		}
		
		assertNotNull(commentDtoList);
	}

}
