package com.naver.booking.api.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naver.booking.api.product.dto.CommentApiDto;
import com.naver.booking.api.product.dto.DisplayInfoApiDto;
import com.naver.booking.api.product.dto.DisplayInfoImageApiDto;
import com.naver.booking.api.product.dto.ProductApiDto;
import com.naver.booking.api.product.dto.ProductImageApiDto;
import com.naver.booking.api.product.dto.ProductPriceApiDto;
import com.naver.booking.api.product.service.ProductApiService;
import com.naver.booking.api.product.service.ProductDisplayInfoIdService;

@RestController
@RequestMapping(path="/api/products")
public class ProductApiController {

	@Autowired
	ProductApiService productApiService;
	
	@Autowired
	ProductDisplayInfoIdService productDisplayInfoIdService;
	
	@GetMapping
	public Map<String, Object> productApiList(@RequestParam(name="categoryId") Long categoryId, @RequestParam(name="start", required=false, defaultValue="0") Long start){
		
		List<ProductApiDto> productApiDtoListByCategoryId = productApiService.getProductsApi(categoryId, start);
		
		Long productApiTotalCountByCategoryId = productApiService.getProductCountByCategory(categoryId);
		
		Map<String, Object> ApiMap = new HashMap<>();
		
		ApiMap.put("totalCount", productApiTotalCountByCategoryId);
		
		ApiMap.put("items", productApiDtoListByCategoryId);
		
		return ApiMap;
	}
	
	@GetMapping("/{displayInfoId}")
	public Map<String, Object> productDisplayInfoIdApiList(@PathVariable(name="displayInfoId") Long displayInfoId){
		
		DisplayInfoApiDto displayInfoApiDto = productDisplayInfoIdService.getDisplayInfoApi(displayInfoId);
		Long productId = (long)displayInfoApiDto.getProductId();
		
		List<ProductImageApiDto> productImageApiDtoList = productDisplayInfoIdService.getProductImageApi(productId);
		
		DisplayInfoImageApiDto displayInfoImageApiDto = productDisplayInfoIdService.getDisplayInfoImageApi(displayInfoId);
		
		List<CommentApiDto> commentApiDtoList = productDisplayInfoIdService.getCommentsApi(productId);
		
		double averageScore = productDisplayInfoIdService.getAverageScore(productId);
		
		List<ProductPriceApiDto> productPriceApiDtoList = productDisplayInfoIdService.getProductPriceApi(productId);
		
		Map<String, Object> ApiMap = new HashMap<>();
		
		ApiMap.put("displayInfo", displayInfoApiDto);
		ApiMap.put("displayInfoImage", displayInfoImageApiDto);
		ApiMap.put("comments", commentApiDtoList);
		ApiMap.put("productImages", productImageApiDtoList);
		ApiMap.put("averageScore", averageScore);
		ApiMap.put("productPrices", productPriceApiDtoList);
		
		return ApiMap;
	}
}
