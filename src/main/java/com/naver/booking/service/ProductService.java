package com.naver.booking.service;

import java.util.List;

import com.naver.booking.dto.ProductDto;

public interface ProductService {

	public List<ProductDto> getProductsDisplayInfoByCategoryId(int categoryId, int start);
	public int getCategoryCountByCategoryId(int categoryId);
}
