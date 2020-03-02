package com.naver.booking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.booking.dao.DisplayInfoImageDao;
import com.naver.booking.dto.DisplayInfoImageDto;
import com.naver.booking.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	DisplayInfoImageDao displayInfoImageDao;
	
	@Override
	public DisplayInfoImageDto getDisplayInfoImage(long displayInfoId) {
		return displayInfoImageDao.selectDisplayInfoImage(displayInfoId);
	}

}
