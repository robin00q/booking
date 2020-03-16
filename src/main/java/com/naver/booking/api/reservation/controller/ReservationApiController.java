package com.naver.booking.api.reservation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.naver.booking.api.reservation.dto.ReservationParamDto;

@RestController
@RequestMapping("/api/reservations")
public class ReservationApiController {

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addReservation(@RequestBody ReservationParamDto reservationParamDto) {
		
		System.out.println(reservationParamDto);
	}
	
	
}
