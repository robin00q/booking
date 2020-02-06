package com.naver.booking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naver.booking.dao.PromotionDao;
import com.naver.booking.dto.PromotionDto;
import com.naver.booking.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService{

	@Autowired
	PromotionDao promotionDao;
	
	@Override
	@Transactional
	public List<PromotionDto> getPromotions() {
		return promotionDao.selectPromotionInformation();
	}

	
}
