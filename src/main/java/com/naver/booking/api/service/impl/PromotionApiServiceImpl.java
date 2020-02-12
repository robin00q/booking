package com.naver.booking.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naver.booking.api.dao.PromotionApiDao;
import com.naver.booking.api.dto.PromotionApiDto;
import com.naver.booking.api.service.PromotionApiService;

@Service
public class PromotionApiServiceImpl implements PromotionApiService{

	@Autowired
	PromotionApiDao promotionApiDao;
	
	@Transactional
	public List<PromotionApiDto> getPromotionsApi() {
		return promotionApiDao.selectPromotionsApi();
	}
	
}
