package com.naver.booking.api.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naver.booking.api.dto.DisplayInfoApiDto;
import com.naver.booking.config.ApplicationConfiguration;

class DisplayInfoApiDaoTest {

	@Autowired
	ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
	
	@Autowired
	DisplayInfoApiDao displayInfoApiDao = ac.getBean(DisplayInfoApiDao.class);
	
	@Test
	void testSelectDisplayInfoApi() {
		int displayInfoId = 1;
		
		DisplayInfoApiDto displayInfoApiDto = displayInfoApiDao.selectDisplayInfoApi(displayInfoId);
		
		System.out.println(displayInfoApiDto.toString());
		
		assertNotNull(displayInfoApiDto);
	}

}
