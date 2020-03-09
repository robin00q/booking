package com.naver.booking.api.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.naver.booking.api.product.dao.ProductApiDao;
import com.naver.booking.api.product.dto.ProductApiDto;
import com.naver.booking.api.product.service.ProductApiService;

@Repository
public class ProductApiServiceImpl implements ProductApiService {

	@Autowired
	ProductApiDao productApiDao;

	@Override
	@Transactional
	public List<ProductApiDto> getProductsApi(Long categoryId, Long start) {
		return productApiDao.SelectProductsApi(categoryId, start);
	}

	@Override
	@Transactional
	public Long getProductCountByCategory(Long categoryId) {
		return productApiDao.SelectProductCountByCategory(categoryId);
	}
	
}
