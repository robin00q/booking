package com.naver.booking.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naver.booking.config.ApplicationConfiguration;
import com.naver.booking.dto.PromotionApiDto;
import com.naver.booking.service.PromotionService;

class PromotionDaoTest {

	@Autowired
	ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
	
	PromotionDao promotionDao = ac.getBean(PromotionDao.class);
	
	@Test
	void testSelectPromotionInformation() {
		List<PromotionApiDto> promotionDtoList = new ArrayList<PromotionApiDto>();
		
		promotionDtoList = promotionDao.selectPromotionsIdProductIdSaveFileName();
		
		for (PromotionApiDto promotionDto : promotionDtoList) {
			System.out.println(promotionDto);
		}
		
		
		assertNotNull(promotionDtoList);
	}

}
