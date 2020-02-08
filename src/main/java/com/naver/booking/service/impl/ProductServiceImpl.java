package com.naver.booking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.booking.dao.ProductDao;
import com.naver.booking.dto.ProductDto;
import com.naver.booking.service.ProductService;

@Repository
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	@Override
	public List<ProductDto> getProductsDisplayInfoByCategoryId(int categoryId, int start) {
		return productDao.SelectProductsDisplayInfoByCategoryId(categoryId, start);
	}

	@Override
	public int getCategoryCountByCategoryId(int categoryId) {
		return productDao.SelectCategoryCountByCategoryId(categoryId);
	}
	
}
