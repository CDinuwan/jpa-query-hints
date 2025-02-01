package com.cdinuwan.jpa_query_hints.service;

import com.cdinuwan.jpa_query_hints.entity.Employee;
import com.cdinuwan.jpa_query_hints.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public Long fetchEmployees() {
        return employeeRepository.count();
    }

    public List<Employee> getEmployeesBySalary(double salary) {
        return employeeRepository.findEmployeesWithSalaryGreaterThan(salary);
    }
}
