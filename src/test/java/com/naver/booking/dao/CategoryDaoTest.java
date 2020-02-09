package com.naver.booking.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naver.booking.config.ApplicationConfiguration;
import com.naver.booking.dto.CategoryApiDto;

class CategoryDaoTest {
	
	@Autowired
	ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
	
	CategoryDao categoryDao = ac.getBean(CategoryDao.class);

	@Test
	void testSelectAll() {
		List<CategoryApiDto> categoryDtoList = new ArrayList<CategoryApiDto>();
		
		categoryDtoList = categoryDao.selectCategoriesIdNameCount();
		
		for (CategoryApiDto categoryDto : categoryDtoList) {
			System.out.println(categoryDto);
		}
		
		assertNotNull(categoryDtoList);
	}

}
