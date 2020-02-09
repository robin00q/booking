package com.naver.booking.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naver.booking.dto.ProductApiDto;
import com.naver.booking.service.ProductService;

@RestController
@RequestMapping(path="/api/products")
public class ProductApiController {

	@Autowired
	ProductService productService;
	
	@GetMapping
	public Map<String, Object> productApiList(@RequestParam(name="categoryId") int categoryId, @RequestParam(name="start", required=false, defaultValue="0") int start){
		
		List<ProductApiDto> productDtoListByCategoryId = productService.getProductsDisplayInfoByCategoryId(categoryId, start);
		
		int productTotalCountByCategoryId = productService.getCategoryCountByCategoryId(categoryId);
		
		Map<String, Object> ApiMap = new HashMap<>();
		
		ApiMap.put("totalCount", productTotalCountByCategoryId);
		
		ApiMap.put("items", productDtoListByCategoryId);
		
		return ApiMap;
	}
}
