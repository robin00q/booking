package com.naver.booking.api.promotion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naver.booking.api.promotion.dao.PromotionApiDao;
import com.naver.booking.api.promotion.dto.PromotionApiDto;
import com.naver.booking.api.promotion.service.PromotionApiService;

@Service
public class PromotionApiServiceImpl implements PromotionApiService{

	@Autowired
	PromotionApiDao promotionApiDao;
	
	@Transactional
	public List<PromotionApiDto> getPromotionsApi() {
		return promotionApiDao.selectPromotionsApi();
	}
	
}
