package com.naver.booking.api.dto;

import java.time.LocalDateTime;

public class ProductImageApiDto {
	private int 			product_id;
	private int 			product_image_id;
	private String 			type;
	private int 			file_info_id;
	private String			file_name;
	private String 			save_file_name;
	private String			content_type;
	private int				delete_flag;
	private LocalDateTime 	current_date;
	private LocalDateTime 	modify_date;
	
	public ProductImageApiDto() {}

	public ProductImageApiDto(int product_id, int product_image_id, String type, int file_info_id, String file_name,
			String save_file_name, String content_type, int delete_flag, LocalDateTime current_date,
			LocalDateTime modify_date) {
		this.product_id = product_id;
		this.product_image_id = product_image_id;
		this.type = type;
		this.file_info_id = file_info_id;
		this.file_name = file_name;
		this.save_file_name = save_file_name;
		this.content_type = content_type;
		this.delete_flag = delete_flag;
		this.current_date = current_date;
		this.modify_date = modify_date;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getProduct_image_id() {
		return product_image_id;
	}

	public void setProduct_image_id(int product_image_id) {
		this.product_image_id = product_image_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getFile_info_id() {
		return file_info_id;
	}

	public void setFile_info_id(int file_info_id) {
		this.file_info_id = file_info_id;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getSave_file_name() {
		return save_file_name;
	}

	public void setSave_file_name(String save_file_name) {
		this.save_file_name = save_file_name;
	}

	public String getContent_type() {
		return content_type;
	}

	public void setContent_type(String content_type) {
		this.content_type = content_type;
	}

	public int getDelete_flag() {
		return delete_flag;
	}

	public void setDelete_flag(int delete_flag) {
		this.delete_flag = delete_flag;
	}

	public LocalDateTime getCurrent_date() {
		return current_date;
	}

	public void setCurrent_date(LocalDateTime current_date) {
		this.current_date = current_date;
	}

	public LocalDateTime getModify_date() {
		return modify_date;
	}

	public void setModify_date(LocalDateTime modify_date) {
		this.modify_date = modify_date;
	}

	@Override
	public String toString() {
		return "ProductImageApiDto [product_id=" + product_id + ", product_image_id=" + product_image_id + ", type="
				+ type + ", file_info_id=" + file_info_id + ", file_name=" + file_name + ", save_file_name="
				+ save_file_name + ", content_type=" + content_type + ", delete_flag=" + delete_flag + ", current_date="
				+ current_date + ", modify_date=" + modify_date + "]";
	}
	
}
