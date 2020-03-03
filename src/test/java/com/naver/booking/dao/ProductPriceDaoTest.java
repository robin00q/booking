package com.naver.booking.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naver.booking.config.ApplicationConfiguration;
import com.naver.booking.dto.ProductPriceDto;
import com.naver.booking.util.PriceFomatter;

class ProductPriceDaoTest {

	@Autowired
	ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
	
	ProductPriceDao productPriceDao = ac.getBean(ProductPriceDao.class);

	@Test
	void testSelectProductPriceByProductId() {
		
		List<ProductPriceDto> productPriceDtoList = new ArrayList<ProductPriceDto>();
		
		long productId = 49;
		
		productPriceDtoList = productPriceDao.selectProductPriceByProductId(productId);
		
		for (ProductPriceDto productPriceDto : productPriceDtoList) {
			System.out.println(productPriceDto);
			System.out.println(PriceFomatter.priceFormat(productPriceDto.getPrice()));
		}
		
		
		assertNotNull(productPriceDtoList);
	}

}
