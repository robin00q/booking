package com.naver.booking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.booking.dao.CommentDao;
import com.naver.booking.dto.CommentDto;
import com.naver.booking.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDao commentDao;
	
	@Override
	public List<CommentDto> getThreeComment(long productId) {
		return commentDao.selectThreeComent(productId);
	}

	@Override
	public double getAverageScore(long productId) {
		return commentDao.selectAverageScore(productId);
	}

}
