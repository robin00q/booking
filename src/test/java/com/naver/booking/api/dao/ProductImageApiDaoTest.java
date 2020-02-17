package com.naver.booking.api.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naver.booking.api.dto.ProductImageApiDto;
import com.naver.booking.config.ApplicationConfiguration;

class ProductImageApiDaoTest {

	@Autowired
	ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
	
	ProductImageApiDao productImageApiDao = ac.getBean(ProductImageApiDao.class);
	
	@Test
	void testSelectProductImageApi() {
		
		List<ProductImageApiDto> productImageApiDtoList = productImageApiDao.selectProductImageApi(39);
		
		for (ProductImageApiDto productImageApiDto : productImageApiDtoList) {
			System.out.println(productImageApiDto);
		}
		
		assertNotNull(productImageApiDtoList);
	}

}
