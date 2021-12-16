package com.example.employeecrmangulardemo.service;

import com.example.employeecrmangulardemo.model.Employee;
import com.example.employeecrmangulardemo.model.Profession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(String id, Employee employee) throws Throwable;

    Employee getEmployeeById(String id) throws Throwable;

    void deleteEmployeeById(String id);

    Page<Employee> getEmployees(String profession, Pageable pageable);
}
