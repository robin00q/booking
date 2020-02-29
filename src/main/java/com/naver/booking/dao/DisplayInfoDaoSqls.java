package com.naver.booking.dao;

public class DisplayInfoDaoSqls {

	public static final String SELECT_DISPLAY_INFO = 
			"SELECT" + 
			"	display_info.place_name as place_name," +
			"	display_info.place_lot as place_lot," +
			"	display_info.place_street as place_street," +
			"	display_info.tel as tel," +
			"	file_info.save_file_name as save_file_name " + 
			"FROM" + 
			"	file_info " + 
			"INNER JOIN" + 
			"	display_info_image " + 
			"ON" + 
			"	display_info_image.file_id = file_info.id " + 
			"INNER JOIN" + 
			"	display_info " + 
			"ON" +
			"	display_info_image.display_info_id = display_info.id " + 
			"WHERE" +
			"	display_info.id = :displayInfoId";
}
