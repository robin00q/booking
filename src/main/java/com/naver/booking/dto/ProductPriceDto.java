package com.naver.booking.dto;

import com.naver.booking.enums.ProductPriceType;
import com.naver.booking.util.PriceFomatter;

public class ProductPriceDto {

	private long productPriceId;
	private long productId;
	private ProductPriceType priceTypeName;
	private long price;
	private double discountRate;
	
	public ProductPriceDto() {}

	public ProductPriceDto(long productPriceId, long productId, String priceTypeName, long price, double discountRate) {
		this.productPriceId = productPriceId;
		this.productId = productId;
		this.priceTypeName = ProductPriceType.getProductPriceTypeByCode(priceTypeName);
		this.price = price;
		this.discountRate = discountRate;
	}

	public long getProductPriceId() {
		return productPriceId;
	}

	public void setProductPriceId(long productPriceId) {
		this.productPriceId = productPriceId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public ProductPriceType getPriceTypeName() {
		return priceTypeName;
	}
	
	public String getKoreanPriceTypeName() {
		return priceTypeName.getDescription();
	}

	public void setPriceTypeName(String priceTypeName) {
		this.priceTypeName = ProductPriceType.getProductPriceTypeByCode(priceTypeName);
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
		return "ProductPriceDto [productPriceId=" + productPriceId + ", productId=" + productId + ", priceTypeName=" + priceTypeName
				+ ", price=" + price + ", discountRate=" + discountRate + "]";
	}
	
	
}
