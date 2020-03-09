package com.naver.booking.api.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naver.booking.api.product.dao.AverageScoreApiDao;
import com.naver.booking.api.product.dao.CommentApiDao;
import com.naver.booking.api.product.dao.DisplayInfoApiDao;
import com.naver.booking.api.product.dao.DisplayInfoImageApiDao;
import com.naver.booking.api.product.dao.ProductImageApiDao;
import com.naver.booking.api.product.dao.ProductPriceApiDao;
import com.naver.booking.api.product.dto.CommentApiDto;
import com.naver.booking.api.product.dto.DisplayInfoApiDto;
import com.naver.booking.api.product.dto.DisplayInfoImageApiDto;
import com.naver.booking.api.product.dto.ProductImageApiDto;
import com.naver.booking.api.product.dto.ProductPriceApiDto;
import com.naver.booking.api.product.service.ProductDisplayInfoIdService;

@Service
public class ProductDisplayInfoIdServiceImpl implements ProductDisplayInfoIdService {

	@Autowired
	DisplayInfoApiDao displayInfoApiDao;
	
	@Autowired
	ProductImageApiDao productImageApiDao;
	
	@Autowired
	DisplayInfoImageApiDao displayInfoImageApiDao;
	
	@Autowired
	CommentApiDao commentApiDao;
	
	@Autowired
	AverageScoreApiDao averageScoreApiDao;
	
	@Autowired
	ProductPriceApiDao productPriceApiDao;
	
	@Override
	@Transactional
	public DisplayInfoApiDto getDisplayInfoApi(long displayInfoId) {
		return displayInfoApiDao.selectDisplayInfoApi(displayInfoId);
	}

	@Override
	@Transactional
	public List<ProductImageApiDto> getProductImageApi(Long productId) {
		return productImageApiDao.selectProductImageApi(productId);
	}

	@Override
	@Transactional
	public DisplayInfoImageApiDto getDisplayInfoImageApi(long displayInfoId) {
		return displayInfoImageApiDao.selectDisplayInfoImageApi(displayInfoId);
	}
	
	@Override
	@Transactional
	public List<CommentApiDto> getCommentsApi(Long productId) {
		return commentApiDao.SelectCommentApiWithComments(productId);
	}

	@Override
	@Transactional
	public Double getAverageScore(Long productId) {
		Double AverageScore = averageScoreApiDao.SelectReservationUserCommentAverageScore(productId); 
		if(AverageScore == null) {
			return 0.0;
		}
		return AverageScore; 
	}

	@Override
	@Transactional
	public List<ProductPriceApiDto> getProductPriceApi(Long productId) {
		return productPriceApiDao.SelectProductPriceApi(productId);
	}


}
