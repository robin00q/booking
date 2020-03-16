package com.naver.booking.enums;

import java.util.HashMap;
import java.util.Map;

public enum ProductPriceType {
	ADULT("A", "성인"),
	YOUTH("Y", "청소년"),
	BABY("B", "유아"),
	SET("S", "세트"),
	DISABLED("D", "장애인"),
	COMMUNITY("C", "지역주민"),
	EARLY_BIRD("E", "얼리버드"),
	EVERY_BODY("R", "모두"),
	VARIFIED("V", "초대받은사람"),;
	
	private final String code;
	private final String description;
	
	private static Map<String, ProductPriceType> productPriceTypeMap = new HashMap<String, ProductPriceType>();
	
	static {
		for(ProductPriceType productPriceType : ProductPriceType.values()) {
			productPriceTypeMap.put(productPriceType.code, productPriceType);
		}
	}
	
	private ProductPriceType(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
	public static ProductPriceType getProductPriceTypeByCode(String code) {
		ProductPriceType productPriceType = productPriceTypeMap.get(code);
		
		if(productPriceType == null) {
			System.out.println(code);
			throw new IllegalArgumentException("Wrong value for price type enum");
		}
		
		return productPriceType;
	}
}
