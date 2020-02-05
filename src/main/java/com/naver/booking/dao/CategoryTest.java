package com.naver.booking.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naver.booking.config.ApplicationConfiguration;
import com.naver.booking.dto.CategoryDto;

public class CategoryTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		
		CategoryDao categoryDao = ac.getBean(CategoryDao.class);
		List<CategoryDto> list = new ArrayList<CategoryDto>();
		
		list = categoryDao.selectAll();
		
		for (CategoryDto categoryDto : list) {
			System.out.println(categoryDto);
		}
	}
}
