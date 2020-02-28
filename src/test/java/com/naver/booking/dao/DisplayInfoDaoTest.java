package com.naver.booking.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naver.booking.config.ApplicationConfiguration;
import com.naver.booking.dto.DisplayInfoDto;

class DisplayInfoDaoTest {

	@Autowired
	ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
	
	DisplayInfoDao displayInfoDao = ac.getBean(DisplayInfoDao.class);
	
	@Test
	void testSelectDisplayInfoSaveFileName() {
		long productId = 4;
		
		DisplayInfoDto displayInfoDto = displayInfoDao.selectDisplayInfoSaveFileName(productId);
		
		System.out.println(displayInfoDto);
		
		assertNotNull(displayInfoDto);
	}

}
