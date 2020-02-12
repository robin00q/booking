package com.naver.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingLoginController {

	@GetMapping("/bookinglogin")
	public String bookingLoginPage() {

		return "bookinglogin";
	}
}
