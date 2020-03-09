package com.naver.booking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naver.booking.dao.ProductDao;
import com.naver.booking.dto.ProductDto;
import com.naver.booking.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;
	
	@Override
	@Transactional
	public ProductDto getProductByDisplayInfoId(long displayInfoId) {
		return productDao.selectProductByDisplayInfoId(displayInfoId);
	}

}
