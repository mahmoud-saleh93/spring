package com.saleh.study.data.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table
@Entity(name="DAILY_ATTENDANCE")
public class Daily_attendance {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@Column(name = "EMP_ID")
	public Long employeeId;
	@Column(name = "DAY")
	public Date day;

	@Column(name="ATTEND_TIME")
	public Timestamp  attendTime;
	@Column(name="DEPART_TIME")
	public Timestamp departTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attendTime == null) ? 0 : attendTime.hashCode());
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((departTime == null) ? 0 : departTime.hashCode());
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Daily_attendance other = (Daily_attendance) obj;
		if (attendTime == null) {
			if (other.attendTime != null)
				return false;
		} else if (!attendTime.equals(other.attendTime))
			return false;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		if (departTime == null) {
			if (other.departTime != null)
				return false;
		} else if (!departTime.equals(other.departTime))
			return false;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Daily_attendance [id=" + id + ", employeeId=" + employeeId + ", day=" + day + ", attendTime="
				+ attendTime + ", departTime=" + departTime + "]";
	}
	
	
	

}
