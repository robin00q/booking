package com.naver.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.naver.booking.dto.CategoryDto;
import com.naver.booking.dto.ProductDto;
import com.naver.booking.dto.PromotionDto;
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
		
		List<PromotionDto> promotionList = promotionService.getPromotionsIdProductIdSaveFileName();
		List<CategoryDto> categoryList = categoryService.getCategoriesIdNameCount();
		List<ProductDto> productList = productService.getProductsDisplayInfoByCategoryId(initialCategoryId, 0);
		
		modelMap.put("promotionList", promotionList);
		modelMap.put("categoryList", categoryList);
		modelMap.put("productList", productList);
		
		return "main";
	}
}
