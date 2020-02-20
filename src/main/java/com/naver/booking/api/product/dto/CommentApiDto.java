package com.naver.booking.api.product.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.naver.booking.util.TimeFormatter;

public class CommentApiDto {
	private int 						commentId;
	private int 						productId;
	private int 						reservationInfoId;
	private int 						score;
	private String 						comment;
	private String 						reservationName;
	private String 						reservationTelephone;
	private String 						reservationEmail;
    private LocalDateTime				reservationDate;
    private LocalDateTime 				createDate;
    private LocalDateTime 				modifyDate;
    private List<CommentImageApiDto> 	commentImages;
	
    public CommentApiDto() {
    	this.commentImages = new ArrayList<CommentImageApiDto>();
    }

	public CommentApiDto(int commentId, int productId, int reservationInfoId, int score, String comment,
			String reservationName, String reservationTelephone, String reservationEmail, LocalDateTime reservationDate,
			LocalDateTime createDate, LocalDateTime modifyDate, List<CommentImageApiDto> commentImages) {
		super();
		this.commentId = commentId;
		this.productId = productId;
		this.reservationInfoId = reservationInfoId;
		this.score = score;
		this.comment = comment;
		this.reservationName = reservationName;
		this.reservationTelephone = reservationTelephone;
		this.reservationEmail = reservationEmail;
		this.reservationDate = reservationDate;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.commentImages = commentImages;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getReservationInfoId() {
		return reservationInfoId;
	}

	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getReservationName() {
		return reservationName;
	}

	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}

	public String getReservationTelephone() {
		return reservationTelephone;
	}

	public void setReservationTelephone(String reservationTelephone) {
		this.reservationTelephone = reservationTelephone;
	}

	public String getReservationEmail() {
		return reservationEmail;
	}

	public void setReservationEmail(String reservationEmail) {
		this.reservationEmail = reservationEmail;
	}

	public String getReservationDate() {
		return TimeFormatter.LocalDateTimeFormatter(reservationDate);
	}

	public void setReservationDate(LocalDateTime reservationDate) {
		this.reservationDate = reservationDate;
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

	public List<CommentImageApiDto> getCommentImages() {
		return commentImages;
	}

	public void setCommentImages(List<CommentImageApiDto> commentImages) {
		this.commentImages = commentImages;
	}
	
	public void addCommentImages(CommentImageApiDto commentImages) {
		this.commentImages.add(commentImages);
	}

	@Override
	public String toString() {
		return "CommentApiDto [commentId=" + commentId + ", productId=" + productId + ", reservationInfoId="
				+ reservationInfoId + ", score=" + score + ", comment=" + comment + ", reservationName="
				+ reservationName + ", reservationTelephone=" + reservationTelephone + ", reservationEmail="
				+ reservationEmail + ", reservationDate=" + reservationDate + ", createDate=" + createDate
				+ ", modifyDate=" + modifyDate + ", commentImages=" + commentImages + "]";
	}
	
    
    
}
