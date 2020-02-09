package com.naver.booking.service;

import java.util.List;

import com.naver.booking.dto.ProductApiDto;

public interface ProductService {

	public List<ProductApiDto> getProductsDisplayInfoByCategoryId(int categoryId, int start);
	public int getCategoryCountByCategoryId(int categoryId);
}
