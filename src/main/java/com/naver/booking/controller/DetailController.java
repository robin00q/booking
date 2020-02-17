package com.naver.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DetailController {

	@GetMapping(path="/detail/{displayInfoId}")
	public String detailPage(@PathVariable("displayInfoId") Long displayInfoId) {
		
		return "detail";
	}
}
