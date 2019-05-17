package com.stackroute.springboot.employeecruddemo.service;

import com.stackroute.springboot.employeecruddemo.dao.EmployeeRepository;
import com.stackroute.springboot.employeecruddemo.entity.Employee;
import com.stackroute.springboot.employeecruddemo.rest.EmployeeRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository emp)
    {
        employeeRepository=emp;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result   = employeeRepository.findById(id);

        Employee employee = null;
        if (result.isPresent())
        {
            employee=result.get();
        }
        else{
            //did n't find employee with id
            throw new RuntimeException("Did not find employee of id - "+id);
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
