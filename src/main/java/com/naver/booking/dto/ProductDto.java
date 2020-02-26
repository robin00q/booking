package com.naver.booking.dto;

public class ProductDto {

	private long id;
	private String description;
	private String content;
	
	public ProductDto() {}

	public ProductDto(long id, String description, String content) {
		this.id = id;
		this.description = description;
		this.content = content;
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

	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", description=" + description + ", content=" + content + "]";
	}

	
}
