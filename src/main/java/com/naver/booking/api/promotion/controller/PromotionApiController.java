package com.naver.booking.api.promotion.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naver.booking.api.promotion.dto.PromotionApiDto;
import com.naver.booking.api.promotion.service.PromotionApiService;

@RestController
@RequestMapping(path="/api/promotions")
public class PromotionApiController {

	@Autowired
	PromotionApiService promotionApiService;
	
	@GetMapping
	public Map<String, Object> promotionApiList(){
		
		List<PromotionApiDto> promotionApiDtoList = promotionApiService.getPromotionsApi();
		
		Map<String, Object> ApiMap = new HashMap<>();
		ApiMap.put("items", promotionApiDtoList);
		
		return ApiMap;
	}
	
}
