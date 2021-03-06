package com.naver.booking.api.product.dto;

import java.time.LocalDateTime;

import com.naver.booking.util.TimeFormatter;

public class DisplayInfoImageApiDto {

	private int 			displayInfoImageId;
	private int 			displayInfoId;
	private int 			fileId;
	private String 			fileName;
	private String 			saveFileName;
	private String 			contentType;
	private boolean			deleteFlag;
	private LocalDateTime 	createDate;
	private LocalDateTime 	modifyDate;
	
	public DisplayInfoImageApiDto() {}

	public DisplayInfoImageApiDto(int displayInfoImageId, int displayInfoId, int fileId, String fileName,
			String saveFileName, String contentType, boolean deleteFlag, LocalDateTime createDate,
			LocalDateTime modifyDate) {
		this.displayInfoImageId = displayInfoImageId;
		this.displayInfoId = displayInfoId;
		this.fileId = fileId;
		this.fileName = fileName;
		this.saveFileName = saveFileName;
		this.contentType = contentType;
		this.deleteFlag = deleteFlag;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public int getDisplayInfoImageId() {
		return displayInfoImageId;
	}

	public void setDisplayInfoImageId(int displayInfoImageId) {
		this.displayInfoImageId = displayInfoImageId;
	}

	public int getDisplayInfoId() {
		return displayInfoId;
	}

	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
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

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getCreateDate() {
		return TimeFormatter.LocalDateTimeFormatter(createDate);
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public String getModifyDate() {
		return TimeFormatter.LocalDateTimeFormatter(modifyDate);
	}

	public void setModifyDate(LocalDateTime modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "DisplayInfoImageApiDto [displayInfoImageId=" + displayInfoImageId + ", displayInfoId=" + displayInfoId
				+ ", fileId=" + fileId + ", fileName=" + fileName + ", saveFileName=" + saveFileName + ", contentType="
				+ contentType + ", deleteFlag=" + deleteFlag + ", createDate=" + createDate + ", modifyDate="
				+ modifyDate + "]";
	}
	
	
	
}
