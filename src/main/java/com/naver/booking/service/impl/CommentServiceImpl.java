package com.naver.booking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naver.booking.dao.CommentDao;
import com.naver.booking.dto.CommentDto;
import com.naver.booking.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDao commentDao;
	
	@Override
	@Transactional
	public List<CommentDto> getThreeComment(long productId) {
		return commentDao.selectThreeComent(productId);
	}

	@Override
	@Transactional
	public List<CommentDto> getComment(long productId) {
		return commentDao.selectComment(productId);
	}

	@Override
	@Transactional
	public double getAverageScore(long productId) {
		Double averageScore = commentDao.selectAverageScore(productId);
		if(averageScore == null) {
			return 0.0;
		}
		return averageScore;
	}

	@Override
	@Transactional
	public String getDescriptionByProductId(long productId) {
		return commentDao.selectDescriptionByProductId(productId);
	}


}
