package com.naver.booking.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naver.booking.dto.CategoryApiDto;
import com.naver.booking.service.CategoryService;

@RestController
@RequestMapping(path="/api/categories")
public class CategoryApiController {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping
	public Map<String, Object> categoryApiList(){
		
		List<CategoryApiDto> categoryDtoList = categoryService.getCategoriesIdNameCount();
		
		Map<String, Object> ApiMap = new HashMap<>();
		
		ApiMap.put("items", categoryDtoList);
		
		return ApiMap;
	}
}
