package com.naver.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.naver.booking.dto.CategoryApiDto;
import com.naver.booking.dto.ProductApiDto;
import com.naver.booking.dto.PromotionApiDto;
import com.naver.booking.service.CategoryService;
import com.naver.booking.service.ProductService;
import com.naver.booking.service.PromotionService;

@Controller
public class MainController {

	@Autowired
	PromotionService promotionService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping(path="/")
	public String mainPage(ModelMap modelMap) {

		int initialCategoryId = 1;
		int totalCategoryCount = 0;
		
		List<PromotionApiDto> promotionList = promotionService.getPromotionsIdProductIdSaveFileName();
		List<CategoryApiDto> categoryList = categoryService.getCategoriesIdNameCount();
		List<ProductApiDto> productList = productService.getProductsDisplayInfoByCategoryId(initialCategoryId, 0);
		
		for (CategoryApiDto categoryApiDto : categoryList) {
			totalCategoryCount += categoryApiDto.getCount();
		}
		
		modelMap.put("promotionList", promotionList);
		modelMap.put("categoryList", categoryList);
		modelMap.put("productList", productList);
		modelMap.put("totalCategoryCount", totalCategoryCount);
		
		return "mainpage";
	}
}
