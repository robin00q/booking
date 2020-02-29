package com.naver.booking.dto;

public class ProductDto {

	private long id;
	private String description;
	private String content;
	private long displayInfoId;
	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDto(long id, String description, String content, long displayInfoId) {
		super();
		this.id = id;
		this.description = description;
		this.content = content;
		this.displayInfoId = displayInfoId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getDisplayInfoId() {
		return displayInfoId;
	}
	public void setDisplayInfoId(long displayInfoId) {
		this.displayInfoId = displayInfoId;
	}
	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", description=" + description + ", content=" + content + ", displayInfoId="
				+ displayInfoId + "]";
	}
}
