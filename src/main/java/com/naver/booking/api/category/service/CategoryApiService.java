package com.naver.booking.api.category.service;

import java.util.List;

import com.naver.booking.api.category.dto.CategoryApiDto;

public interface CategoryApiService {

	/* /api/categories */
	public List<CategoryApiDto> getCategoriesApi();
}
