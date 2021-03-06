package com.naver.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.naver.booking.dto.CommentDto;
import com.naver.booking.dto.ProductDto;
import com.naver.booking.service.CommentService;
import com.naver.booking.service.ProductService;

@Controller
public class ReviewController {

	@Autowired
	CommentService commentService;
	
	@Autowired
	ProductService productService;

	@GetMapping(path = "/review/{displayInfoId}")
	public String reviewPage(@PathVariable("displayInfoId") Long displayInfoId, ModelMap modelMap) {

		ProductDto productDto = productService.getProductByDisplayInfoId(displayInfoId);
		long productId = productDto.getId();
		List<CommentDto> commentDtoList = commentService.getComment(productId);
		double averageScore = commentService.getAverageScore(productId);
		String description = commentService.getDescriptionByProductId(productId);

		averageScore = Math.round(averageScore * 10) / 10.0;

		modelMap.put("productDto", productDto);
		modelMap.put("description", description);
		modelMap.put("commentDtoList", commentDtoList);
		modelMap.put("averageScore", averageScore);

		return "review";
	}
}
