package com.naver.booking.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naver.booking.api.dto.CategoryApiDto;
import com.naver.booking.api.service.CategoryApiService;

@RestController
@RequestMapping(path="/api/categories")
public class CategoryApiController {

	@Autowired
	CategoryApiService categoryApiService;
	
	@GetMapping
	public Map<String, Object> categoryApiList(){
		
		List<CategoryApiDto> categoryApiDtoList = categoryApiService.getCategoriesApi();
		
		Map<String, Object> ApiMap = new HashMap<>();
		
		ApiMap.put("items", categoryApiDtoList);
		
		return ApiMap;
	}
}
