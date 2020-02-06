package com.naver.booking.dto;

public class PromotionDto {

	private int 	id;
	private int 	productId;
	private String  saveFileName;
	
	public PromotionDto() {}

	public PromotionDto(int id, int productId, String saveFileName) {
		this.id = id;
		this.productId = productId;
		this.saveFileName = saveFileName;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	@Override
	public String toString() {
		return "PromotionDto [id=" + id + ", productId=" + productId + ", saveFileName=" + saveFileName + "]";
	}
	
	
}
