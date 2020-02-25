package com.naver.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.naver.booking.api.product.dto.DisplayInfoApiDto;
import com.naver.booking.api.product.dto.ProductImageApiDto;
import com.naver.booking.api.product.service.ProductDisplayInfoIdService;
import com.naver.booking.dto.CommentDto;
import com.naver.booking.service.CommentService;

@Controller
public class DetailController {
	
	@Autowired
	ProductDisplayInfoIdService productDisplayInfoIdService;
	
	@Autowired
	CommentService commentService;
	
	@GetMapping(path="/detail/{displayInfoId}")
	public String detailPage(@PathVariable("displayInfoId") Long displayInfoId, ModelMap modelMap) {
		
		DisplayInfoApiDto displayInfoApiDto = productDisplayInfoIdService.getDisplayInfoApi(displayInfoId);
		int productId = displayInfoApiDto.getProductId();
		
		List<ProductImageApiDto> productImageApiDtoList = productDisplayInfoIdService.getProductImageApi((long) productId);
		
		List<CommentDto> commentDtoList = commentService.getThreeComment(productId);
		double averageScore = commentService.getAverageScore(productId);
		averageScore = Math.round(averageScore*10)/10.0;
		
		modelMap.put("displayInfoApiDto", displayInfoApiDto);
		modelMap.put("productImageApiDtoList", productImageApiDtoList);
		modelMap.put("commentDtoList", commentDtoList);
		modelMap.put("averageScore", averageScore);
		
		return "detail";
	}
	
	
}
