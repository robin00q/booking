package com.naver.booking.api.service;

import java.util.List;

import com.naver.booking.api.dto.CommentApiDto;
import com.naver.booking.api.dto.DisplayInfoApiDto;
import com.naver.booking.api.dto.ProductImageApiDto;
import com.naver.booking.api.dto.ProductPriceApiDto;

public interface ProductDisplayInfoIdService {

	/* /api/products/{displayInfoId} */
	public DisplayInfoApiDto getDisplayInfoApi(long displayInfoId);
	public List<ProductImageApiDto> getProductImageApi(Long productId);
	public List<CommentApiDto> getCommentsApi();
	public double getAverageScore(Long productId);
	public List<ProductPriceApiDto> getProductPriceApi(Long productId);
	
}
