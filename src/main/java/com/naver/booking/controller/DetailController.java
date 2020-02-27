package com.naver.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.naver.booking.api.product.dto.ProductImageApiDto;
import com.naver.booking.api.product.service.ProductDisplayInfoIdService;
import com.naver.booking.dto.CommentDto;
import com.naver.booking.dto.ProductDto;
import com.naver.booking.service.CommentService;
import com.naver.booking.service.DisplayInfoImageService;
import com.naver.booking.service.ProductService;

@Controller
public class DetailController {
	
	@Autowired
	ProductDisplayInfoIdService productDisplayInfoIdService;
	
	@Autowired
	ProductService ProductService;
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	DisplayInfoImageService displayInfoImageService;
	
	@GetMapping(path="/detail/{productId}")
	public String detailPage(@PathVariable("productId") Long productId, ModelMap modelMap) {
		
		ProductDto productDto = ProductService.getProductByProductId(productId);
		
		List<ProductImageApiDto> productImageApiDtoList = productDisplayInfoIdService.getProductImageApi((long) productId);
		
		List<CommentDto> commentDtoList = commentService.getThreeComment(productId);
		
		double averageScore = commentService.getAverageScore(productId);
		
		String saveFileName = displayInfoImageService.getDisplayInfoSaveFileName(productId);
		
		averageScore = Math.round(averageScore*10)/10.0;
		
		
		modelMap.put("productDto", productDto);
		modelMap.put("saveFileName", saveFileName);
		modelMap.put("productImageApiDtoList", productImageApiDtoList);
		modelMap.put("commentDtoList", commentDtoList);
		modelMap.put("averageScore", averageScore);
		
		return "detail";
	}
	
	
}
