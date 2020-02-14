package com.naver.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DetailController {

	@GetMapping(path="/detail")
	public String detailPage() {
		
		return "detail";
	}
	
	
}
