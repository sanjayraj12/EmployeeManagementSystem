package com.example.ew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ew.entity.Employee;

import com.example.ew.serviceimpl.EmployeeServiceImpl;

@RestController
@RequestMapping("/em")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeserviceimpl;
	
	public EmployeeController( EmployeeServiceImpl employeeserviceimpl) {
		super();
		this.employeeserviceimpl = employeeserviceimpl;
	}

	@PostMapping("/postsss")
	public ResponseEntity<Employee>saveemployee( @RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(employeeserviceimpl.saveemployee(employee),HttpStatus.OK);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee>getempid(@PathVariable long id)
	{
		return new ResponseEntity<Employee>(employeeserviceimpl.getempid(id),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public List<Employee>getemall(Employee employee)
	{
		return employeeserviceimpl.getemall(employee);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Employee>updateemp(@PathVariable long id,@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(employeeserviceimpl.updateemp(employee, id),HttpStatus.OK);
		
	}
	
	@DeleteMapping("{id}")
	public String delemp(@PathVariable long id)
	{
		employeeserviceimpl.delemp(id);
		return "Succesfully deleted";
		
	}

}
