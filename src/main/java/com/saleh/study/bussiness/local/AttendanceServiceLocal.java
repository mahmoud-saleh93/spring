package com.saleh.study.bussiness.local;

import java.util.List;

import com.saleh.study.models.Attendace;

public interface AttendanceServiceLocal {

	public boolean addEmployee(String name);
	public boolean removeEmployee(String name);
	public List<Attendace> getMonthlyAttendanceForAnEmployee(String name, Integer day, Integer year);
	public Attendace getDailyAttendanceForAnEmployee(String name, Integer day, Integer month, Integer year);
	public List<Attendace> getMonthlyAttendanceForAllEmployee();
	public List<Attendace> getDailyAttendanceForAllEmployee();
	public boolean attend(String name);
	public boolean depart(String name);
	public List<Attendace> getLateEmployeeForAmonth();
}
