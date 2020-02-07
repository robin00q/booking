package com.naver.booking.dto;

public class CategoryDto {

	private int 	id;
	private String 	name;
	private int 	count;
	
	public CategoryDto() {}
	
	public CategoryDto(int id, String name, int count) {
		this.id = id;
		this.name = name;
		this.count = count;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CategoryDto [id=" + id + ", name=" + name + ", count=" + count + "]";
	}

}
