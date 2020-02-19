package com.naver.booking.api.promotion.service;

import java.util.List;

import com.naver.booking.api.promotion.dto.PromotionApiDto;

public interface PromotionApiService {

	/* /api/promotions */
	public List<PromotionApiDto> getPromotionsApi();
	
}
