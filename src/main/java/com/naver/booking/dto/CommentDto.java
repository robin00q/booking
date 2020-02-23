package com.naver.booking.dto;

import java.time.LocalDateTime;

import com.naver.booking.util.TimeFormatter;

public class CommentDto {

	private String 			comment;
	private String 			saveFileName;
	private String 			reservationEmail;
	private double 			score;
	private LocalDateTime 	reservationDate;
	
	public CommentDto() {}

	public CommentDto(String comment, String saveFileName, String reservationEmail, double score,
			LocalDateTime reservationDate) {
		super();
		this.comment = comment;
		this.saveFileName = saveFileName;
		this.reservationEmail = reservationEmail;
		this.score = score;
		this.reservationDate = reservationDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public String getReservationEmail() {
		return reservationEmail;
	}

	public void setReservationEmail(String reservationEmail) {
		this.reservationEmail = reservationEmail;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getReservationDate() {
		return TimeFormatter.LocalDateTimeFormatter(reservationDate);
	}

	public void setReservationDate(LocalDateTime reservationDate) {
		this.reservationDate = reservationDate;
	}

	@Override
	public String toString() {
		return "CommentDto [comment=" + comment + ", saveFileName=" + saveFileName + ", reservationEmail="
				+ reservationEmail + ", score=" + score + ", reservationDate=" + reservationDate + "]";
	}
	
}
