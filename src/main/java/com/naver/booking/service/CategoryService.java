package com.naver.booking.service;

import java.util.List;

import com.naver.booking.dto.CategoryDto;

public interface CategoryService {

	/* /api/categories */
	public List<CategoryDto> getCategoriesIdNameCount();
}
