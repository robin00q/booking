package com.naver.booking.api.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naver.booking.api.dto.ProductPriceApiDto;
import com.naver.booking.config.ApplicationConfiguration;

class ProductPriceApiDaoTest {

	@Autowired
	ApplicationContext ac =  new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
	
	ProductPriceApiDao productPriceApiDao = ac.getBean(ProductPriceApiDao.class);
	
	@Test
	void testSelectProductPriceApi() {

		Long productId = (long) 1;
		
		List<ProductPriceApiDto> productPriceApiDtoList = productPriceApiDao.SelectProductPriceApi(productId);
		
		for (ProductPriceApiDto productPriceApiDto : productPriceApiDtoList) {
			System.out.println(productPriceApiDto);
		}

		assertNotNull(productPriceApiDtoList);
	}

}
