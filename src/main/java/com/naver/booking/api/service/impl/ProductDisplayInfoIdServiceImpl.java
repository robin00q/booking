package com.naver.booking.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.booking.api.dao.AverageScoreApiDao;
import com.naver.booking.api.dao.CommentApiDao;
import com.naver.booking.api.dao.DisplayInfoApiDao;
import com.naver.booking.api.dao.ProductImageApiDao;
import com.naver.booking.api.dao.ProductPriceApiDao;
import com.naver.booking.api.dto.CommentApiDto;
import com.naver.booking.api.dto.DisplayInfoApiDto;
import com.naver.booking.api.dto.ProductImageApiDto;
import com.naver.booking.api.dto.ProductPriceApiDto;
import com.naver.booking.api.service.ProductDisplayInfoIdService;

@Service
public class ProductDisplayInfoIdServiceImpl implements ProductDisplayInfoIdService {

	@Autowired
	DisplayInfoApiDao displayInfoApiDao;
	
	@Autowired
	ProductImageApiDao productImageApiDao;
	
	@Autowired
	CommentApiDao commentApiDao;
	
	@Autowired
	AverageScoreApiDao averageScoreApiDao;
	
	@Autowired
	ProductPriceApiDao productPriceApiDao;
	
	@Override
	public DisplayInfoApiDto getDisplayInfoApi(long displayInfoId) {
		return displayInfoApiDao.selectDisplayInfoApi(displayInfoId);
	}

	@Override
	public List<ProductImageApiDto> getProductImageApi(Long productId) {
		return productImageApiDao.selectProductImageApi(productId);
	}

	@Override
	public List<CommentApiDto> getCommentsApi() {
		return null;
	}

	@Override
	public double getAverageScore(Long productId) {
		return averageScoreApiDao.SelectReservationUserCommentAverageScore(productId);
	}

	@Override
	public List<ProductPriceApiDto> getProductPriceApi(Long productId) {
		return productPriceApiDao.SelectProductPriceApi(productId);
	}

}
