package com.example.ew.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ew.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
