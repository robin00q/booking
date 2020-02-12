package com.naver.booking.api.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naver.booking.api.dao.CategoryApiDao;
import com.naver.booking.api.dto.CategoryApiDto;
import com.naver.booking.config.ApplicationConfiguration;

class CategoryApiDaoTest {
	
	@Autowired
	ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
	
	CategoryApiDao categoryApiDao = ac.getBean(CategoryApiDao.class);

	@Test
	void testSelectAll() {
		List<CategoryApiDto> categoryApiDtoList = new ArrayList<CategoryApiDto>();
		
		categoryApiDtoList = categoryApiDao.selectCategoriesApi();
		
		for (CategoryApiDto categoryApiDto : categoryApiDtoList) {
			System.out.println(categoryApiDto);
		}
		
		assertNotNull(categoryApiDtoList);
	}

}
