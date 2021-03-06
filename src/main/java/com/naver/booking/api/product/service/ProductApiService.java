package com.naver.booking.api.product.service;

import java.util.List;

import com.naver.booking.api.product.dto.ProductApiDto;

public interface ProductApiService {

	/* /api/products? */
	public List<ProductApiDto> getProductsApi(Long categoryId, Long start);
	public Long getProductCountByCategory(Long categoryId);
	
}
