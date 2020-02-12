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
	DisplayInfoService displayInfoService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	CategoryApiService categoryApiService;
	
	@Autowired
	ProductApiService productApiService;
	
	
	@GetMapping(path="/")
	public String mainPage(ModelMap modelMap) {
		int initialCategoryId = 1;
		
		List<PromotionApiDto> promotionApiList = promotionApiService.getPromotionsApi();
		int displayInfoTotalCount = displayInfoService.getDisplayInfoTotalCount();
		List<CategoryDto> categoryList = categoryService.getCategoryIdName();
		
		List<CategoryApiDto> categoryApiList = categoryApiService.getCategoriesApi();
		List<ProductApiDto> productApiList = productApiService.getProductsApi(initialCategoryId, 0);
		
		modelMap.put("promotionApiList", promotionApiList);
		modelMap.put("displayInfoTotalCount", displayInfoTotalCount);
		modelMap.put("categoryList", categoryList);
		modelMap.put("categoryApiList", categoryApiList);
		modelMap.put("productApiList", productApiList);
		
		return "mainpage";
	}
}
