package com.example.employeecrmangulardemo.dao;

import com.example.employeecrmangulardemo.model.Employee;
import com.example.employeecrmangulardemo.model.Profession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    Page<Employee> getEmployeesByProfession(Profession profession, Pageable pageable);
}
