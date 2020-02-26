package com.naver.booking.service;

import java.util.List;

import com.naver.booking.dto.CommentDto;

public interface CommentService {

	public List<CommentDto> getThreeComment(long productId);
	public List<CommentDto> getComment(long productId);
	public double getAverageScore(long productId);
	public String getDescriptionByProductId(long productId);
}
