package com.naver.booking.dto;

import com.naver.booking.util.PriceFomatter;

public class ProductPriceDto {

	private long id;
	private long productId;
	private char priceTypeName;
	private long price;
	private double discountRate;
	
	public ProductPriceDto() {}

	public ProductPriceDto(long id, long productId, char priceTypeName, long price, double discountRate) {
		super();
		this.id = id;
		this.productId = productId;
		this.priceTypeName = priceTypeName;
		this.price = price;
		this.discountRate = discountRate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public char getPriceTypeName() {
		return priceTypeName;
	}

	public void setPriceTypeName(char priceTypeName) {
		this.priceTypeName = priceTypeName;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	
	public String getFormattedPrice() {
		return PriceFomatter.priceFormat(price);
	}

	@Override
	public String toString() {
		return "ProductPriceDto [id=" + id + ", productId=" + productId + ", priceTypeName=" + priceTypeName
				+ ", price=" + price + ", discountRate=" + discountRate + "]";
	}
	
	
}
