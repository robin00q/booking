package com.naver.booking.api.reservation.dto;

public class PriceDto {

	private long count;
	private long productPriceId;

	public PriceDto() {}

	public PriceDto(long count, long productPriceId) {
		this.count = count;
		this.productPriceId = productPriceId;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public long getProductPriceId() {
		return productPriceId;
	}

	public void setProductPriceId(long productPriceId) {
		this.productPriceId = productPriceId;
	}

	@Override
	public String toString() {
		return "PriceDto [count=" + count + ", productPriceId=" + productPriceId + "]";
	}
	
	
}
