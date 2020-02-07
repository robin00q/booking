package com.naver.booking.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naver.booking.dto.PromotionDto;
import com.naver.booking.service.PromotionService;

@RestController
@RequestMapping(path="/api/promotions")
public class PromotionApiController {

	@Autowired
	PromotionService promotionService;
	
	@GetMapping
	public Map<String, Object> promotionApiList(){
		
		List<PromotionDto> promotionDtoList = promotionService.getPromotionsIdProductIdSaveFileName();
		
		Map<String, Object> ApiMap = new HashMap<>();
		ApiMap.put("items", promotionDtoList);
		
		return ApiMap;
	}
	
}
