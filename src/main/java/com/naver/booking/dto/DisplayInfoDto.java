package com.naver.booking.dto;

public class DisplayInfoDto {

	private String placeName;
	private String placeLot;
	private String placeStreet;
	private String tel;
	private String saveFileName;
	
	public DisplayInfoDto() {}

	public DisplayInfoDto(String placeName, String placeLot, String placeStreet, String tel, String saveFileName) {
		this.placeName = placeName;
		this.placeLot = placeLot;
		this.placeStreet = placeStreet;
		this.tel = tel;
		this.saveFileName = saveFileName;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getPlaceLot() {
		return placeLot;
	}

	public void setPlaceLot(String placeLot) {
		this.placeLot = placeLot;
	}

	public String getPlaceStreet() {
		return placeStreet;
	}

	public void setPlaceStreet(String placeStreet) {
		this.placeStreet = placeStreet;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	@Override
	public String toString() {
		return "DisplayInfoDto [placeName=" + placeName + ", placeLot=" + placeLot + ", placeStreet=" + placeStreet
				+ ", tel=" + tel + ", saveFileName=" + saveFileName + "]";
	}
	
}
