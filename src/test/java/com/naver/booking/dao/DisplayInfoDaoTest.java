package com.naver.booking.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naver.booking.config.ApplicationConfiguration;
import com.naver.booking.dao.DisplayInfoDao;

class DisplayInfoDaoTest {

	@Autowired
	ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
	
	DisplayInfoDao displayInfoDao = ac.getBean(DisplayInfoDao.class);
	
	@Test
	void testSelectDisplayInfoTotalCount() {
		int totalCount = displayInfoDao.selectDisplayInfoTotalCount();
		
		System.out.println(totalCount);
		
		assertTrue(totalCount > 0);
	}

}
