package com.naver.booking.api.reservation.dto;

import java.util.List;

public class ReservationParamDto {

	private long 	displayInfoId;
	private long 	productId;
	private String 	reservationEmail;
	private String 	reservationName;
	private String 	reservationTelephone;
	
	private List<PriceDto> prices;

	public ReservationParamDto() {}

	public ReservationParamDto(long displayInfoId, long productId, String reservationEmail, String reservationName,
			String reservationTelephone, String reservationYearMonthDay, List<PriceDto> prices) {
		super();
		this.displayInfoId = displayInfoId;
		this.productId = productId;
		this.reservationEmail = reservationEmail;
		this.reservationName = reservationName;
		this.reservationTelephone = reservationTelephone;
		this.prices = prices;
	}

	public long getDisplayInfoId() {
		return displayInfoId;
	}

	public void setDisplayInfoId(long displayInfoId) {
		this.displayInfoId = displayInfoId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getReservationEmail() {
		return reservationEmail;
	}

	public void setReservationEmail(String reservationEmail) {
		this.reservationEmail = reservationEmail;
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

	public List<PriceDto> getPrices() {
		return prices;
	}

	public void setPrices(List<PriceDto> prices) {
		this.prices = prices;
	}

	@Override
	public String toString() {
		return "ReservationParamDto [displayInfoId=" + displayInfoId + ", productId=" + productId
				+ ", reservationEmail=" + reservationEmail + ", reservationName=" + reservationName
				+ ", reservationTelephone=" + reservationTelephone + ", prices=" + prices + "]";
	}
	
	
}

