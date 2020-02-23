package com.naver.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.naver.booking.api.product.dto.CommentApiDto;
import com.naver.booking.api.product.dto.DisplayInfoApiDto;
import com.naver.booking.api.product.dto.ProductImageApiDto;
import com.naver.booking.api.product.service.ProductDisplayInfoIdService;

@Controller
public class DetailController {
	
	@Autowired
	ProductDisplayInfoIdService productDisplayInfoIdService;
	
	@GetMapping(path="/detail/{displayInfoId}")
	public String detailPage(@PathVariable("displayInfoId") Long displayInfoId, ModelMap modelMap) {
		
		DisplayInfoApiDto displayInfoApiDto = productDisplayInfoIdService.getDisplayInfoApi(displayInfoId);
		int productId = displayInfoApiDto.getProductId();
		
		List<ProductImageApiDto> productImageApiDtoList = productDisplayInfoIdService.getProductImageApi((long) productId);
		
		List<CommentApiDto> commentApiDtoList = productDisplayInfoIdService.getCommentsApi((long) productId);
		
		modelMap.put("displayInfoApiDto", displayInfoApiDto);
		modelMap.put("productImageApiDtoList", productImageApiDtoList);
		modelMap.put("commentApiDtoList", commentApiDtoList);
		
		return "detail";
	}
	
	
}
