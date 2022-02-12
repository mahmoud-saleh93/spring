package com.saleh.study.bussiness;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saleh.study.bussiness.local.AttendanceServiceLocal;
import com.saleh.study.bussiness.utils.DateUtils;
import com.saleh.study.data.entity.Daily_attendance;
import com.saleh.study.data.entity.Employee;
import com.saleh.study.data.repository.Daily_attendanceRepository;
import com.saleh.study.data.repository.EmployeeRepository;
import com.saleh.study.models.Attendace;

@Service
public class AttendanceService implements AttendanceServiceLocal {

	private final EmployeeRepository employeeRepository;
	private final Daily_attendanceRepository dailyAttendanceRepository;
	
	@Autowired
	public AttendanceService(EmployeeRepository employeeRepository,
			Daily_attendanceRepository dailyAttendanceRepository) {
		this.employeeRepository = employeeRepository;
		this.dailyAttendanceRepository = dailyAttendanceRepository;
	}

	@Override
	public boolean addEmployee(String name) {
		Employee emp= new Employee();
		emp.setName(name);
		if(employeeRepository.save(emp)!=null)
			return true;
		else
			return false;
	}

	@Override
	public boolean removeEmployee(String name) {
		Employee emp = employeeRepository.findByName(name);
		if(emp!=null) {
			employeeRepository.deleteById(emp.employeeId);
			return true;
		}else {
			return false;
		}
		 
	}

	@Override
	public List<Attendace> getMonthlyAttendanceForAnEmployee(String name, Integer day, Integer year) {
		Employee emp = employeeRepository.findByName(name);
		if(emp!=null) {
			 List<Attendace> att= new ArrayList<Attendace>();
			 List<Daily_attendance> daList= new ArrayList<Daily_attendance>();
			 daList = dailyAttendanceRepository.findByEmpIdAndMonth(day, year, emp.employeeId);
			 if(daList.isEmpty()) {
				 System.out.println("111");
				 return null;
			 } else {
				 daList.forEach(attendance->{
					 Attendace atte = new Attendace();
					 atte.setAttendTime(attendance.getAttendTime());
					 atte.setDay(attendance.getDay());
					 atte.setDepartTime(attendance.getDepartTime());
					 atte.setName(emp.getName());
					 System.out.println(atte.toString());
					 att.add(atte);
					 });
				 return att;
			 }
			 
			
		}else {
			return null;
		}
	}

	@Override
	public Attendace getDailyAttendanceForAnEmployee(String name, Integer day, Integer month, Integer year) {
		
		Employee emp = employeeRepository.findByName(name);
		if(emp!=null) {
			 List<Attendace> att= new ArrayList<Attendace>();
			 List<Daily_attendance> daList= new ArrayList<Daily_attendance>();
			 daList = dailyAttendanceRepository.findByEmpIdAndMonthAndDay(day, month,  year, emp.employeeId);
			 if(daList.isEmpty()) {
				 System.out.println("111");
				 return null;
			 } else {
				
					 Attendace atte = new Attendace();
					 atte.setAttendTime(daList.get(0).getAttendTime());
					 atte.setDay(daList.get(0).getDay());
					 atte.setDepartTime(daList.get(0).getDepartTime());
					 atte.setName(emp.getName());
					 System.out.println(atte.toString());
							
				 return atte;
			 }
			 
			
		}else {
			return null;
		}
	
	}

	@Override
	public List<Attendace> getMonthlyAttendanceForAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Attendace> getDailyAttendanceForAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean attend(String name) {
		Employee emp = employeeRepository.findByName(name);
		if(emp!=null) {
			if(!dailyAttendanceRepository.findByDayAndIdForAttendance(DateUtils.getCurrentDayDate(), emp.employeeId).isEmpty() ) {
				
				System.out.println("sss");
				return false;
			}
			 Date date = new Date(0);  
			Daily_attendance da= new Daily_attendance();
			da.setEmployeeId(emp.getEmployeeId());
			da.setDay(DateUtils.getCurrentDayDate());
			da.setAttendTime(Timestamp.valueOf(LocalDateTime.now()));
			dailyAttendanceRepository.save(da);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean depart(String name) {
		Employee emp = employeeRepository.findByName(name);
		if(emp!=null) {
			if(!dailyAttendanceRepository.findByDayAndIdForDeparture(DateUtils.getCurrentDayDate(), emp.employeeId).isEmpty()) {
				
				return false;
			}
			// Date date = new Date(0);  
			Daily_attendance daNew= new Daily_attendance();
			List<Daily_attendance> daList = dailyAttendanceRepository.findByDayAndIdForAttendance(DateUtils.getCurrentDayDate(), emp.employeeId);
			if(daList.isEmpty()) {
				return false;
			}else {
				Daily_attendance da = daList.get(0);
			
			daNew.setId(da.getId());
			daNew.setEmployeeId(da.getEmployeeId());
			daNew.setDay(da.getDay());
			daNew.setAttendTime(da.getAttendTime());
			daNew.setDepartTime(Timestamp.valueOf(LocalDateTime.now()));
			
			dailyAttendanceRepository.save(daNew);
			return true;
			}
		}else {
			return false;
		}
	}

	@Override
	public List<Attendace> getLateEmployeeForAmonth() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
