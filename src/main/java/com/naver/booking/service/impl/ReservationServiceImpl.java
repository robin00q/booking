package com.naver.booking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naver.booking.dao.DisplayInfoImageDao;
import com.naver.booking.dao.ProductPriceDao;
import com.naver.booking.dto.DisplayInfoImageDto;
import com.naver.booking.dto.ProductPriceDto;
import com.naver.booking.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	DisplayInfoImageDao displayInfoImageDao;
	
	@Autowired
	ProductPriceDao productPriceDao;
	
	@Override
	@Transactional
	public DisplayInfoImageDto getDisplayInfoImage(long displayInfoId) {
		return displayInfoImageDao.selectDisplayInfoImage(displayInfoId);
	}

	@Override
	@Transactional
	public List<ProductPriceDto> getProductPriceByProductId(long productId) {
		return productPriceDao.selectProductPriceByProductId(productId);
	}




}
