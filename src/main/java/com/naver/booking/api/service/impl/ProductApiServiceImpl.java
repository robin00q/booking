package com.naver.booking.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.booking.api.dao.ProductApiDao;
import com.naver.booking.api.dto.ProductApiDto;
import com.naver.booking.api.service.ProductApiService;

@Repository
public class ProductApiServiceImpl implements ProductApiService {

	@Autowired
	ProductApiDao productApiDao;

	@Override
	public List<ProductApiDto> getProductsApi(Long categoryId, Long start) {
		return productApiDao.SelectProductsApi(categoryId, start);
	}

	@Override
	public Long getProductCountByCategory(Long categoryId) {
		return productApiDao.SelectProductCountByCategory(categoryId);
	}
	
}
