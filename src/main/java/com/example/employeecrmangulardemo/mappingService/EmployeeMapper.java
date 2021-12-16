package com.example.employeecrmangulardemo.mappingService;

import com.example.employeecrmangulardemo.dto.EmployeeRequest;
import com.example.employeecrmangulardemo.dto.EmployeeResponse;
import com.example.employeecrmangulardemo.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface EmployeeMapper {

    @Mapping(target = "profession", source = "request.profession")
    Employee employeeRequestToEmployee(EmployeeRequest request);

    @Mapping(target = "profession", source = "employee.profession")
    EmployeeResponse employeeToEmployeeResponse(Employee employee);
}
