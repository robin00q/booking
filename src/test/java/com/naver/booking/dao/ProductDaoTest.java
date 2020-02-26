package com.naver.booking.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naver.booking.config.ApplicationConfiguration;
import com.naver.booking.dto.ProductDto;

class ProductDaoTest {
	
	@Autowired
	ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
	
	ProductDao productDao = ac.getBean(ProductDao.class);


	@Test
	void testSelectProductByProductId() {
		
		long productId = 2;
		
		ProductDto productDto = new ProductDto();
		
		productDto = productDao.selectProductByProductId(productId);
		
		System.out.println(productDto);
				
		assertNotNull(productDto);
	}

}
