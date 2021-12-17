package com.example.employeecrmangulardemo.controller;

import com.example.employeecrmangulardemo.dto.EmployeeRequest;
import com.example.employeecrmangulardemo.dto.EmployeeResponse;
import com.example.employeecrmangulardemo.mappingService.EmployeeMapper;
import com.example.employeecrmangulardemo.model.Employee;
import com.example.employeecrmangulardemo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    private final EmployeeMapper mapper;

    private final EmployeeService employeeService;

    private final static String STORE_URI = "http://localhost:8080/api/v1/employees";


    @PostMapping
    public ResponseEntity<EmployeeResponse> saveEmployee(@RequestBody EmployeeRequest request) {

        Employee employee = mapper.employeeRequestToEmployee(request);
        Employee storedEmployee = employeeService.saveEmployee(employee);
        EmployeeResponse response = mapper.employeeToEmployeeResponse(storedEmployee);

        return ResponseEntity.created(URI.create(STORE_URI)).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable("id") String id) throws Throwable {

        Employee employeeById = employeeService.getEmployeeById(id);
        EmployeeResponse response = mapper.employeeToEmployeeResponse(employeeById);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable("id") String id, @RequestBody EmployeeRequest request) throws Throwable {

        Employee employee = mapper.employeeRequestToEmployee(request);
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        EmployeeResponse response = mapper.employeeToEmployeeResponse(updatedEmployee);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable("id") String id) {

        employeeService.deleteEmployeeById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<EmployeeResponse>> getEmployees(@RequestParam(value = "profession", required = false) String profession, @PageableDefault(size = 20, sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable) {

        Page<EmployeeResponse> response = employeeService.getEmployees(profession, pageable).map(mapper::employeeToEmployeeResponse);

        return ResponseEntity.ok(response);
    }
}
