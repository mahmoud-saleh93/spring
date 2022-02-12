package com.saleh.study.data.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.saleh.study.data.entity.Daily_attendance;
@Repository
public interface Daily_attendanceRepository extends CrudRepository<Daily_attendance, Long> {

//
//	@Query(value="SELECT d FROM Daily_attendance as d  WHERE d.day=:day")
//	Daily_attendance findByDay( @Param("day") String day);
//	
	
	
	@Query( value = "SELECT * FROM Daily_attendance a  WHERE a.day=?1 and a.EMP_ID =?2 and a.attend_time is not null ", 
			  nativeQuery = true)
	List<Daily_attendance> findByDayAndIdForAttendance(Date day, Long employeeId);
	
	@Query( value = "SELECT * FROM Daily_attendance a  WHERE a.day=?1 and a.EMP_ID =?2 and a.depart_time is not null", 
			  nativeQuery = true)
	List<Daily_attendance> findByDayAndIdForDeparture(Date day, Long employeeId);
	
//	@Query("select case when count(d)> 0 then true else false end FROM DailyAttendance d  WHERE d.name=:name and d.day=:day")
//	Boolean findByNameAndDay( @Param("name") String name,  @Param("day") String day);
	
//	
	@Query( value = "select * from daily_attendance a where EXTRACT(MONTH FROM day)=?1 and EXTRACT(YEAR FROM day)=?2 and EMP_ID =?3", 
			  nativeQuery = true)
	List<Daily_attendance> findByEmpIdAndMonth(Integer day, Integer year, Long employeeId);
	
	
	@Query( value = "select * from daily_attendance a where EXTRACT(DAY FROM day)=?1 and EXTRACT(MONTH FROM day)=?2 and EXTRACT(YEAR FROM day)=?3 and EMP_ID =?4", 
			  nativeQuery = true)
	List<Daily_attendance> findByEmpIdAndMonthAndDay(Integer day, Integer month, Integer year, Long employeeId);
	
	
	}
