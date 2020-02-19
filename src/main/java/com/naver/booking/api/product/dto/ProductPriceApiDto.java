package com.naver.booking.api.product.dto;

import java.time.LocalDateTime;

public class ProductPriceApiDto {

	private int 			productPriceId;
	private int 			productId;
	private String 			priceTypeName;
	private int 			price;
	private int 			discountRate;
	private LocalDateTime 	createDate;
	private LocalDateTime 	modifyDate;
	
	public ProductPriceApiDto() {}

	public ProductPriceApiDto(int productPriceId, int productId, String priceTypeName, int price, int discountRate,
			LocalDateTime createDate, LocalDateTime modifyDate) {
		this.productPriceId = productPriceId;
		this.productId = productId;
		this.priceTypeName = priceTypeName;
		this.price = price;
		this.discountRate = discountRate;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public int getProductPriceId() {
		return productPriceId;
	}

	public void setProductPriceId(int productPriceId) {
		this.productPriceId = productPriceId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getPriceTypeName() {
		return priceTypeName;
	}

	public void setPriceTypeName(String priceTypeName) {
		this.priceTypeName = priceTypeName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(LocalDateTime modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "ProductPriceApiDto [productPriceId=" + productPriceId + ", productId=" + productId + ", priceTypeName="
				+ priceTypeName + ", price=" + price + ", discountRate=" + discountRate + ", createDate=" + createDate
				+ ", modifyDate=" + modifyDate + "]";
	}
	
}
