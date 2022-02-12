package com.saleh.study.bussiness.utils;

import java.sql.Date;
import java.time.LocalDate;


public class DateUtils {

	public static Date getCurrentDayDate() {
//		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
		   LocalDate now = LocalDate.now();  
//		  return dtf.format(now);
		   return Date.valueOf(now);
	}
}
