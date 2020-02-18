package com.naver.booking.api.dto;

import java.time.LocalDateTime;

public class CommentImageApiDto {

	private int 			imageId;
	private int 			reservationInfoId;
	private int 			reservationUserCommentId;
	private int 			fileId;
	private String 		fileName;
	private String 		saveFileName;
	private String 		contentType;
	private boolean 		deleteFlag;
	private LocalDateTime 	createDate;
	private LocalDateTime 	modifyDate;
	
	public CommentImageApiDto() {}

	public CommentImageApiDto(int imageId, int reservationInfoId, int reservationUserCommentId, int fileId,
			String fileName, String saveFileName, String contentType, boolean deleteFlag, LocalDateTime createDate,
			LocalDateTime modifyDate) {
		super();
		this.imageId = imageId;
		this.reservationInfoId = reservationInfoId;
		this.reservationUserCommentId = reservationUserCommentId;
		this.fileId = fileId;
		this.fileName = fileName;
		this.saveFileName = saveFileName;
		this.contentType = contentType;
		this.deleteFlag = deleteFlag;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public int getReservationInfoId() {
		return reservationInfoId;
	}

	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}

	public int getReservationUserCommentId() {
		return reservationUserCommentId;
	}

	public void setReservationUserCommentId(int reservationUserCommentId) {
		this.reservationUserCommentId = reservationUserCommentId;
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
		return "CommentImagesApiDto [imageId=" + imageId + ", reservationInfoId=" + reservationInfoId
				+ ", reservationUserCommentId=" + reservationUserCommentId + ", fileId=" + fileId + ", fileName="
				+ fileName + ", saveFileName=" + saveFileName + ", contentType=" + contentType + ", deleteFlag="
				+ deleteFlag + ", createDate=" + createDate + ", modifyDate=" + modifyDate + "]";
	}
	
	
}
