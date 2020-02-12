package com.naver.booking.api.service;

import java.util.List;

import com.naver.booking.api.dto.ProductApiDto;

public interface ProductApiService {

	public List<ProductApiDto> getProductsApi(int categoryId, int start);
	public int getProductCountByCategory(int categoryId);
	
}
