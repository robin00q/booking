package com.naver.booking.api.product.service;

import java.util.List;

import com.naver.booking.api.product.dto.CommentApiDto;
import com.naver.booking.api.product.dto.DisplayInfoApiDto;
import com.naver.booking.api.product.dto.DisplayInfoImageApiDto;
import com.naver.booking.api.product.dto.ProductImageApiDto;
import com.naver.booking.api.product.dto.ProductPriceApiDto;

public interface ProductDisplayInfoIdService {

	/* /api/products/{displayInfoId} */
	public DisplayInfoApiDto getDisplayInfoApi(long displayInfoId);
	public List<ProductImageApiDto> getProductImageApi(Long productId);
	public DisplayInfoImageApiDto getDisplayInfoImageApi(long displayInfoId);
	public List<CommentApiDto> getCommentsApi(Long productId);
	public Double getAverageScore(Long productId);
	public List<ProductPriceApiDto> getProductPriceApi(Long productId);
	
}
