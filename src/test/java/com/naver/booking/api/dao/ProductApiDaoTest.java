package com.naver.booking.api.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naver.booking.api.product.dao.ProductApiDao;
import com.naver.booking.api.product.dto.ProductApiDto;
import com.naver.booking.config.ApplicationConfiguration;

class ProductApiDaoTest {

	@Autowired
	ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

	ProductApiDao productApiDao = ac.getBean(ProductApiDao.class);

	@Test
	void testSelectProductsJoinProductDisplayInfo() {
		List<ProductApiDto> productApiDtoList = new ArrayList<ProductApiDto>();

		Long categoryId = (long) 0;
		Long start = (long) 0;
		
		productApiDtoList = productApiDao.SelectProductsApi(categoryId, start);

		for (ProductApiDto productApiDto : productApiDtoList) {
			System.out.println(productApiDto);
		}

		assertNotNull(productApiDtoList);
	}
	
	@Test
	void testSelectProductCountByCategory() {
		Long categoryId = (long) 0;
		
		Long CategoryCount = productApiDao.SelectProductCountByCategory(categoryId);
		
		System.out.println(CategoryCount);
		
		assertTrue(CategoryCount>0);
	}

}
