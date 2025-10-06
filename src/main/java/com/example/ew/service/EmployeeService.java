package com.example.ew.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.ew.entity.Employee;

@Service
public interface EmployeeService {
	
	Employee saveemployee(Employee employee);
	
	Employee getempid(long id);
	
	List <Employee> getemall(Employee employee);
	
	Employee updateemp(@RequestBody Employee employee ,@PathVariable Long id);
	
	public void delemp(long id);
	

}
