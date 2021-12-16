package com.example.employeecrmangulardemo;

import com.example.employeecrmangulardemo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class EmployeeCrmAngularDemoApplication {

    private final EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeCrmAngularDemoApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//
//        Employee TEST_EMPLOYEE_1 = Employee.builder().firstName("Alex").lastName("Petrov").age(22).profession(Profession.SOFTWARE_ENGINEER).build();
//        Employee TEST_EMPLOYEE_2 = Employee.builder().firstName("Petr").lastName("Ivanov").age(32).profession(Profession.PM).build();
//        Employee TEST_EMPLOYEE_3 = Employee.builder().firstName("Oleg").lastName("Kruglov").age(35).profession(Profession.CEO).build();
//        Employee TEST_EMPLOYEE_4 = Employee.builder().firstName("Galina").lastName("Kalinina").age(27).profession(Profession.HR).build();
//        Employee TEST_EMPLOYEE_5 = Employee.builder().firstName("Will").lastName("Smith").age(42).profession(Profession.CEO).build();
//
//        List.of(TEST_EMPLOYEE_1, TEST_EMPLOYEE_2, TEST_EMPLOYEE_3, TEST_EMPLOYEE_4, TEST_EMPLOYEE_5).forEach(employeeService::saveEmployee);
//    }
}
