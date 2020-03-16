package com.naver.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.naver.booking.dto.DisplayInfoImageDto;
import com.naver.booking.dto.ProductDto;
import com.naver.booking.dto.ProductPriceDto;
import com.naver.booking.service.ProductService;
import com.naver.booking.service.ReservationService;

@Controller
public class ReserveController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ReservationService reservationService;

	@GetMapping("/reserve/{displayInfoId}")
	public String Reserve(@PathVariable("displayInfoId") Long displayInfoId, ModelMap modelMap) {
		
		ProductDto productDto = productService.getProductByDisplayInfoId(displayInfoId);
		
		long productId = productDto.getId();
		
		DisplayInfoImageDto displayInfoImageDto = reservationService.getDisplayInfoImage(displayInfoId);
		
		List<ProductPriceDto> productPriceDtoList = reservationService.getProductPriceByProductId(productId);
		
		modelMap.put("displayInfoImageDto", displayInfoImageDto);
		modelMap.put("productPriceDtoList", productPriceDtoList);
		
		
		return "reserve";
	}
	
}
