package com.naver.booking.api.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naver.booking.api.promotion.dao.PromotionApiDao;
import com.naver.booking.api.promotion.dto.PromotionApiDto;
import com.naver.booking.config.ApplicationConfiguration;

class PromotionApiDaoTest {

	@Autowired
	ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
	
	PromotionApiDao promotionApiDao = ac.getBean(PromotionApiDao.class);
	
	@Test
	void testSelectPromotionInformation() {
		List<PromotionApiDto> promotionApiDtoList = new ArrayList<PromotionApiDto>();
		
		promotionApiDtoList = promotionApiDao.selectPromotionsApi();
		
		for (PromotionApiDto promotionApiDto : promotionApiDtoList) {
			System.out.println(promotionApiDto);
		}                                               
		
		
		assertNotNull(promotionApiDtoList);
	}

}
