package com.naver.booking.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naver.booking.config.ApplicationConfiguration;

class DisplayInfoImageDaoTest {

	@Autowired
	ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
	
	DisplayInfoImageDao displayInfoImageDao = ac.getBean(DisplayInfoImageDao.class);
	
	@Test
	void testSelectDisplayInfoSaveFileName() {
		long productId = 4;
		
		String saveFileName = displayInfoImageDao.selectDisplayInfoSaveFileName(productId);
		
		System.out.println(saveFileName);
		
		assertNotNull(saveFileName);
	}

}
