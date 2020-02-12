package com.naver.booking.api.service;

import java.util.List;

import com.naver.booking.api.dto.CategoryApiDto;

public interface CategoryApiService {

	/* /api/categories */
	public List<CategoryApiDto> getCategoriesApi();
}
