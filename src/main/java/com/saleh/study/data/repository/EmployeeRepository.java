package com.saleh.study.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.saleh.study.data.entity.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	@Query("SELECT e FROM Employee e  WHERE e.name=:name")
	Employee findByName( @Param("name") String name);
}
