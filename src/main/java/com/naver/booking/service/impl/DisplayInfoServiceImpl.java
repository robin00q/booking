package com.naver.booking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.booking.dao.DisplayInfoDao;
import com.naver.booking.service.DisplayInfoService;

@Service
public class DisplayInfoServiceImpl implements DisplayInfoService{

	@Autowired
	DisplayInfoDao displayInfoDao;
	
	@Override
	public int getDisplayInfoTotalCount() {
		return displayInfoDao.selectDisplayInfoTotalCount();
	}

	
}
