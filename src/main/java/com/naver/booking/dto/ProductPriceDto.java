package com.naver.booking.dto;

public class ProductPriceDto {

	private long id;
	private long productId;
	private char price_type_name;
	private long price;
	private double discount_rate;
	public ProductPriceDto() {}
	public ProductPriceDto(long id, long productId, char price_type_name, long price, double discount_rate) {
		this.id = id;
		this.productId = productId;
		this.price_type_name = price_type_name;
		this.price = price;
		this.discount_rate = discount_rate;
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
	public char getPrice_type_name() {
		return price_type_name;
	}
	public void setPrice_type_name(char price_type_name) {
		this.price_type_name = price_type_name;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public double getDiscount_rate() {
		return discount_rate;
	}
	public void setDiscount_rate(double discount_rate) {
		this.discount_rate = discount_rate;
	}
	@Override
	public String toString() {
		return "ProductPriceDto [id=" + id + ", productId=" + productId + ", price_type_name=" + price_type_name
				+ ", price=" + price + ", discount_rate=" + discount_rate + "]";
	}
}
