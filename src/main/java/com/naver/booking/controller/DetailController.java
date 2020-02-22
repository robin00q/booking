package com.naver.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.naver.booking.api.product.dao.DisplayInfoApiDao;
import com.naver.booking.api.product.dao.ProductImageApiDao;
import com.naver.booking.api.product.dto.DisplayInfoApiDto;
import com.naver.booking.api.product.dto.ProductImageApiDto;

@Controller
public class DetailController {
	
	@Autowired
	DisplayInfoApiDao displayInfoApiDao;
	
	@Autowired
	ProductImageApiDao productImageApiDao;

	@GetMapping(path="/detail/{displayInfoId}")
	public String detailPage(@PathVariable("displayInfoId") Long displayInfoId, ModelMap modelMap) {
		
		DisplayInfoApiDto displayInfoApiDto = displayInfoApiDao.selectDisplayInfoApi(displayInfoId);
		int productId = displayInfoApiDto.getProductId();
		
		List<ProductImageApiDto> productImageApiDtoList = productImageApiDao.selectProductImageApi((long) productId);
		
		modelMap.put("displayInfoApiDto", displayInfoApiDto);
		modelMap.put("productImageApiDtoList", productImageApiDtoList);
		
		return "detail";
	}
	
	
}
