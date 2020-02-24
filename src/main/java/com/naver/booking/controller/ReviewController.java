package com.naver.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ReviewController {

	@GetMapping(path="/review/{productId}")
	public String reviewPage(@PathVariable("productId") Long productId) {
		return "review";
	}
}
