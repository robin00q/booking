package com.naver.booking.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naver.booking.config.ApplicationConfiguration;
import com.naver.booking.dto.ProductApiDto;

class ProductDaoTest {

	@Autowired
	ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

	ProductDao productDao = ac.getBean(ProductDao.class);

	@Test
	void testSelectProductsJoinProductDisplayInfo() {
		List<ProductApiDto> productDtoList = new ArrayList<ProductApiDto>();

		int categoryId = 3;
		int start = 0;
		
		productDtoList = productDao.SelectProductsDisplayInfoByCategoryId(categoryId, start);

		for (ProductApiDto productDto : productDtoList) {
			System.out.println(productDto);
		}

		assertNotNull(productDtoList);
	}
	
	@Test
	void testSelectCategoryCount() {
		int categoryId = 3;
		
		int CategoryCount = productDao.SelectCategoryCountByCategoryId(categoryId);
		
		System.out.println(CategoryCount);
		
		assertTrue(CategoryCount>0);
	}

}
