package com.naver.booking.api.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naver.booking.api.product.dao.DisplayInfoImageApiDao;
import com.naver.booking.api.product.dto.DisplayInfoImageApiDto;
import com.naver.booking.config.ApplicationConfiguration;

class DisplayInfoImageApiDaoTest {

	@Autowired
	ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
	
	DisplayInfoImageApiDao displayInfoImageApiDao = ac.getBean(DisplayInfoImageApiDao.class);
	
	@Test
	void testDisplayInfoImageApiDao() {
		int displayInfoId = 45;
		
		DisplayInfoImageApiDto displayInfoImageApiDto = displayInfoImageApiDao.selectDisplayInfoImageApi(displayInfoId);
		
		System.out.println(displayInfoImageApiDto);
		
		assertNotNull(displayInfoImageApiDto);
	}

}
