package com.naver.booking.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "com.naver.booking.dao",  "com.naver.booking.service"})
@Import({ DatabaseConfiguration.class })
public class ApplicationConfiguration {

}
