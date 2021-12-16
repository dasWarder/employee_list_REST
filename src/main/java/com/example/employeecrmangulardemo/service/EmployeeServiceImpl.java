package com.example.employeecrmangulardemo.service;

import com.example.employeecrmangulardemo.dao.EmployeeRepository;
import com.example.employeecrmangulardemo.model.Employee;
import com.example.employeecrmangulardemo.model.Profession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {

        log.info("In EmployeeService.saveEmployee - Store a new employee");

        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(String id, Employee employee) throws Throwable {

        if (employeeRepository.existsById(id)) {

            log.info("In EmployeeService.updateEmployee - Update employee by id = {}", id);
            employee.setId(id);

            return employeeRepository.save(employee);
        } else {

            log.error("In EmployeeService.updateEmployee - Employee not found exception occurred");

            throw new Throwable(String.format("Employee with id = %s not found", id));
        }
    }

    @Override
    public Employee getEmployeeById(String id) throws Throwable {

        log.info("In EmployeeService.getEmployeeById - Fetch an employee by id = {}", id);

        return employeeRepository.findById(id).orElseThrow(Throwable::new);
    }

    @Override
    public void deleteEmployeeById(String id) {

        employeeRepository.deleteById(id);

        log.info("In EmployeeService.deleteEmployeeById - Delete an employee by id ={}", id);
    }

    @Override
    public Page<Employee> getEmployees(String profession, Pageable pageable) {

        if(Objects.isNull(profession)) {

            log.info("In EmployeeService.getEmployees - Fetch all employees");
            return employeeRepository.findAll(pageable);

        } else {

            log.info("In EmployeeService.getEmployees - Fetch employees by profession = {}", profession);
            return employeeRepository.getEmployeesByProfession(Profession.valueOf(profession), pageable);
        }
    }
}
