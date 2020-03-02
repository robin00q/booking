package com.naver.booking.dto;

public class DisplayInfoImageDto {

	private int 	displayInfoId;
	private String 	openingHours;
	private String 	placeStreet;
	private String 	saveFileName;
	public DisplayInfoImageDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DisplayInfoImageDto(int displayInfoId, String openingHours, String placeStreet, String saveFileName) {
		super();
		this.displayInfoId = displayInfoId;
		this.openingHours = openingHours;
		this.placeStreet = placeStreet;
		this.saveFileName = saveFileName;
	}
	public int getDisplayInfoId() {
		return displayInfoId;
	}
	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}
	public String getOpeningHours() {
		return openingHours;
	}
	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}
	public String getPlaceStreet() {
		return placeStreet;
	}
	public void setPlaceStreet(String placeStreet) {
		this.placeStreet = placeStreet;
	}
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	@Override
	public String toString() {
		return "DisplayInfoImageDto [displayInfoId=" + displayInfoId + ", openingHours=" + openingHours
				+ ", placeStreet=" + placeStreet + ", saveFileName=" + saveFileName + "]";
	}
}
