package com.naver.booking.service;

import com.naver.booking.dto.ProductDto;

public interface ProductService {

	public ProductDto getProductByDisplayInfoId(long productId);
}
