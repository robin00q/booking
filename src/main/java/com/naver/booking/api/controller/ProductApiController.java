package com.naver.booking.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naver.booking.api.dto.ProductApiDto;
import com.naver.booking.api.service.ProductApiService;

@RestController
@RequestMapping(path="/api/products")
public class ProductApiController {

	@Autowired
	ProductApiService productApiService;
	
	@GetMapping
	public Map<String, Object> productApiList(@RequestParam(name="categoryId") int categoryId, @RequestParam(name="start", required=false, defaultValue="0") int start){
		
		List<ProductApiDto> productApiDtoListByCategoryId = productApiService.getProductsApi(categoryId, start);
		
		int productApiTotalCountByCategoryId = productApiService.getProductCountByCategory(categoryId);
		
		Map<String, Object> ApiMap = new HashMap<>();
		
		ApiMap.put("totalCount", productApiTotalCountByCategoryId);
		
		ApiMap.put("items", productApiDtoListByCategoryId);
		
		return ApiMap;
	}
}
