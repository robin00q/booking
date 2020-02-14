package com.naver.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.naver.booking.api.dto.CategoryApiDto;
import com.naver.booking.api.dto.ProductApiDto;
import com.naver.booking.api.dto.PromotionApiDto;
import com.naver.booking.api.service.CategoryApiService;
import com.naver.booking.api.service.ProductApiService;
import com.naver.booking.api.service.PromotionApiService;
import com.naver.booking.dto.CategoryDto;
import com.naver.booking.service.CategoryService;
import com.naver.booking.service.DisplayInfoService;

@Controller
public class MainController {

	@Autowired
	PromotionApiService promotionApiService;
	
	@Autowired
	CategoryService categoryService;
	
	
	@GetMapping(path="/")
	public String mainPage(ModelMap modelMap) {
		List<PromotionApiDto> promotionApiList = promotionApiService.getPromotionsApi();
		List<CategoryDto> categoryList = categoryService.getCategoryIdName();
		
		modelMap.put("promotionApiList", promotionApiList);
		modelMap.put("categoryList", categoryList);
		
		return "mainpage";
	}
}
