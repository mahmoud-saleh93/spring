package com.saleh.study.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saleh.study.models.Attendace;

import com.saleh.study.bussiness.local.AttendanceServiceLocal;

@RestController
public class Controller {
	@Autowired
	AttendanceServiceLocal attendanceService;
	
	@GetMapping("/add")
	public boolean addEmployee(@RequestParam(value="name", required = true)String name) {
		return attendanceService.addEmployee(name);
	}
	
	@GetMapping("/delete")
	public boolean removeEmployee(@RequestParam(value="name", required = true)String name) {
		return attendanceService.removeEmployee(name);
	}
	
	@GetMapping("/attend")
	public boolean attend(String name) {
		return attendanceService.attend(name);
	}

	@GetMapping("/depart")
	public boolean depart(String name) {
		return attendanceService.depart(name);
	}
	
	
	@GetMapping("/monthlyforemp")
	public List<Attendace> getMonthlyAttendanceForAnEmployee(@RequestParam(value="name")String name, @RequestParam(value="month")Integer day, @RequestParam(value="year")Integer year) {
		return attendanceService.getMonthlyAttendanceForAnEmployee(name, day, year);
	}
	
	@GetMapping("/dailyforemp")
	public Attendace getMonthlyAttendanceForAnEmployee(@RequestParam(value="name")String name, @RequestParam(value="day")Integer day,  @RequestParam(value="month")Integer month,  @RequestParam(value="year")Integer year) {
		return attendanceService.getDailyAttendanceForAnEmployee(name, day, month, year);
	}
	
	
}
