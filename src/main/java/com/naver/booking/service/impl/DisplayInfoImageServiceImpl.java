package com.naver.booking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.booking.dao.DisplayInfoImageDao;
import com.naver.booking.service.DisplayInfoImageService;

@Service
public class DisplayInfoImageServiceImpl implements DisplayInfoImageService {

	@Autowired
	DisplayInfoImageDao displayInfoImageDao; 
	
	@Override
	public String getDisplayInfoSaveFileName(long productId) {
		return displayInfoImageDao.selectDisplayInfoSaveFileName(productId);
	}

}
