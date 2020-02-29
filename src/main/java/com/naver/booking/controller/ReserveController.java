package com.naver.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ReserveController {

	@GetMapping("/reserve/{displayInfoId}")
	public String Reserve(@PathVariable("displayInfoId") Long displayInfoId) {
		
		return "reserve";
	}
}
