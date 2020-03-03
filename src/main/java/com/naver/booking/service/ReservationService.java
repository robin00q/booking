package com.naver.booking.service;

import java.util.List;

import com.naver.booking.dto.DisplayInfoImageDto;
import com.naver.booking.dto.ProductPriceDto;

public interface ReservationService {

	public DisplayInfoImageDto getDisplayInfoImage(long displayInfoId);
	
	public List<ProductPriceDto> getProductPriceByProductId(long productId);
}
