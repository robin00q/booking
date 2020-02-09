package com.naver.booking.service;

import java.util.List;

import com.naver.booking.dto.CategoryApiDto;

public interface CategoryService {

	/* /api/categories */
	public List<CategoryApiDto> getCategoriesIdNameCount();
}
