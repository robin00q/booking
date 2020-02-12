package com.naver.booking.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naver.booking.api.dao.CategoryApiDao;
import com.naver.booking.api.dto.CategoryApiDto;
import com.naver.booking.api.service.CategoryApiService;

@Service
public class CategoryApiServiceImpl implements CategoryApiService {

	@Autowired
	CategoryApiDao categoryApiDao;
	
	@Transactional
	public List<CategoryApiDto> getCategoriesApi() {
		return categoryApiDao.selectCategoriesApi();
	}

}
