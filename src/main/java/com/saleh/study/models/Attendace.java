package com.saleh.study.models;

import java.sql.Date;
import java.sql.Timestamp;


public class Attendace {

	public String name;
	public Date day;
	public Timestamp  attendTime;
	public Timestamp departTime;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public Timestamp getAttendTime() {
		return attendTime;
	}
	public void setAttendTime(Timestamp attendTime) {
		this.attendTime = attendTime;
	}
	public Timestamp getDepartTime() {
		return departTime;
	}
	public void setDepartTime(Timestamp departTime) {
		this.departTime = departTime;
	}
	@Override
	public String toString() {
		return "Attendace [name=" + name + ", day=" + day + ", attendTime=" + attendTime + ", departTime=" + departTime
				+ "]";
	}
	
	
	
}
