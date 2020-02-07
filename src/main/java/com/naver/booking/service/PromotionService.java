package com.naver.booking.service;

import java.util.List;

import com.naver.booking.dto.PromotionDto;

public interface PromotionService {

	/* /api/promotions */
	public List<PromotionDto> getPromotionsIdProductIdSaveFileName();
	
}
