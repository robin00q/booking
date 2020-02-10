package com.naver.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyReservationController {

	@GetMapping("/myreservation")
	public String myReservationPage() {
		
		return "myreservation";
	}
}
