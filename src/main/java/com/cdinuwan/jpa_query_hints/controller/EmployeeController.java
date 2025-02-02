package com.cdinuwan.jpa_query_hints.controller;

import com.cdinuwan.jpa_query_hints.entity.Employee;
import com.cdinuwan.jpa_query_hints.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("/getEmployeeCount/{amount}")
    public ResponseEntity<List<Employee>> getEmployeesBySalaryRange(@PathVariable double amount) {
        return ResponseEntity.ok(employeeService.getEmployeesBySalary(amount));
    }

    @GetMapping("/getEmployeeCount")
    public ResponseEntity<String> getTotalEmployeeCount() {
        return ResponseEntity.ok("Total employees record counts =" + employeeService.fetchEmployees());
    }
}
