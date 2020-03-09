package com.naver.booking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naver.booking.dao.CategoryDao;
import com.naver.booking.dto.CategoryDto;
import com.naver.booking.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	@Override
	@Transactional
	public List<CategoryDto> getCategoryIdName() {
		return categoryDao.selectCategoryIdName();
	}

}
