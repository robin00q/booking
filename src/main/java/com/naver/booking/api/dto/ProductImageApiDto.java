package com.naver.booking.api.dto;

import java.time.LocalDateTime;

public class ProductImageApiDto {
	private int 			productId;
	private int 			productImageId;
	private String 			type;
	private int 			fileInfoId;
	private String			fileName;
	private String 			saveFileName;
	private String			contentType;
	private String			deleteFlag;
	private LocalDateTime 	createDate;
	private LocalDateTime 	modifyDate;
	
	public ProductImageApiDto() {}
	
	public ProductImageApiDto(int productId, int productImageId, String type, int fileInfoId, String fileName,
			String saveFileName, String contentType, String deleteFlag, LocalDateTime createDate,
			LocalDateTime modifyDate) {
		this.productId = productId;
		this.productImageId = productImageId;
		this.type = type;
		this.fileInfoId = fileInfoId;
		this.fileName = fileName;
		this.saveFileName = saveFileName;
		this.contentType = contentType;
		this.deleteFlag = deleteFlag;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductImageId() {
		return productImageId;
	}
	public void setProductImageId(int productImageId) {
		this.productImageId = productImageId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getFileInfoId() {
		return fileInfoId;
	}
	public void setFileInfoId(int fileInfoId) {
		this.fileInfoId = fileInfoId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		if(deleteFlag == 0) {
			this.deleteFlag = "false";
		} else {
			this.deleteFlag = "true";
		}
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
		return "ProductImageApiDto [productId=" + productId + ", productImageId=" + productImageId + ", type=" + type
				+ ", fileInfoId=" + fileInfoId + ", fileName=" + fileName + ", saveFileName=" + saveFileName
				+ ", contentType=" + contentType + ", deleteFlag=" + deleteFlag + ", createDate=" + createDate
				+ ", modifyDate=" + modifyDate + "]";
	}
	
	
	
	
}
