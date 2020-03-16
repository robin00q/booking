package com.naver.booking.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { 
		"com.naver.booking.dao",  "com.naver.booking.service", 
		"com.naver.booking.api.category.dao", "com.naver.booking.api.category.service",
		"com.naver.booking.api.product.dao", "com.naver.booking.api.product.service",
		"com.naver.booking.api.promotion.dao", "com.naver.booking.api.promotion.service",
		"com.naver.booking.api.reservation.dao", "com.naver.booking.api.reservation.service"
		})
@Import({ DatabaseConfiguration.class })
public class ApplicationConfiguration {

}
