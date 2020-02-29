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
import com.naver.booking.dto.DisplayInfoDto;
import com.naver.booking.dto.ProductDto;
import com.naver.booking.service.CommentService;
import com.naver.booking.service.DisplayInfoService;
import com.naver.booking.service.ProductService;

@Controller
public class DetailController {
	
	@Autowired
	ProductDisplayInfoIdService productDisplayInfoIdService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	DisplayInfoService displayInfoImageService;
	
	@GetMapping(path="/detail/{displayInfoId}")
	public String detailPage(@PathVariable("displayInfoId") Long displayInfoId, ModelMap modelMap) {
		
		ProductDto productDto = productService.getProductByDisplayInfoId(displayInfoId);
		
		DisplayInfoDto displayInfoDto = displayInfoImageService.getDisplayInfoSaveFileName(displayInfoId);

		long productId = productDto.getId();
		
		List<ProductImageApiDto> productImageApiDtoList = productDisplayInfoIdService.getProductImageApi(productId);
		
		List<CommentDto> commentDtoList = commentService.getThreeComment(productId);
		
		double averageScore = commentService.getAverageScore(productId);
		
		
		averageScore = Math.round(averageScore*10)/10.0;
		
		
		modelMap.put("productDto", productDto);
		modelMap.put("displayInfoDto", displayInfoDto);
		modelMap.put("productImageApiDtoList", productImageApiDtoList);
		modelMap.put("commentDtoList", commentDtoList);
		modelMap.put("averageScore", averageScore);
		
		return "detail";
	}
	
	
}
