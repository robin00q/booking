package com.naver.booking.api.service;

import java.util.List;

import com.naver.booking.api.dto.PromotionApiDto;

public interface PromotionApiService {

	/* /api/promotions */
	public List<PromotionApiDto> getPromotionsApi();
	
}
