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
import com.naver.booking.service.DisplayInfoService;

@Controller
public class MainController {

	@Autowired
	PromotionApiService promotionApiService;
	
	@Autowired
	CategoryApiService categoryApiService;
	
	@Autowired
	ProductApiService productApiService;
	
	@Autowired
	DisplayInfoService displayInfoService;
	
	@GetMapping(path="/")
	public String mainPage(ModelMap modelMap) {

		int initialCategoryId = 1;
		
		int displayInfoTotalCount = displayInfoService.getDisplayInfoTotalCount();
		List<PromotionApiDto> promotionApiList = promotionApiService.getPromotionsApi();
		List<CategoryApiDto> categoryApiList = categoryApiService.getCategoriesApi();
		List<ProductApiDto> productApiList = productApiService.getProductsApi(initialCategoryId, 0);
		
		modelMap.put("promotionApiList", promotionApiList);
		modelMap.put("categoryApiList", categoryApiList);
		modelMap.put("productApiList", productApiList);
		modelMap.put("displayInfoTotalCount", displayInfoTotalCount);
		
		return "mainpage";
	}
}
