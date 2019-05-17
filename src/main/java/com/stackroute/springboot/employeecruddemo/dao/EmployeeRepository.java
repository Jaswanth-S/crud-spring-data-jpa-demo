package com.stackroute.springboot.employeecruddemo.dao;

import com.stackroute.springboot.employeecruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
