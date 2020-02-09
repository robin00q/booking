package com.naver.booking.service;

import java.util.List;

import com.naver.booking.dto.PromotionApiDto;

public interface PromotionService {

	/* /api/promotions */
	public List<PromotionApiDto> getPromotionsIdProductIdSaveFileName();
	
}
