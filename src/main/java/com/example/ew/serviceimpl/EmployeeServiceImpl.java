package com.example.ew.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ew.entity.Employee;
import com.example.ew.exception.ResourceNotFoundException;
import com.example.ew.repository.EmployeeRepository;
import com.example.ew.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeerepo;

	public EmployeeServiceImpl(EmployeeRepository employeerepo) {
		super();
		this.employeerepo = employeerepo;
	}

	@Override
	public Employee saveemployee(Employee employee) {
		
		return employeerepo.save(employee);
	}

	@Override
	public Employee getempid(long id) {
		
		Optional<Employee>empstatus=employeerepo.findById(id);
		
		if(empstatus.isPresent())
		{
			return empstatus.get();		}
				
		else
		{
			throw new ResourceNotFoundException("Employee"," Id", id);
		}
	}

	@Override
	public List<Employee> getemall(Employee employee) {
		
		return employeerepo.findAll();
	}

	@Override
	public Employee updateemp(Employee employee, Long id) {
		
		Employee empstatus=employeerepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee"," Id", id) );
		
		empstatus.setFirstname(employee.getFirstname());
		empstatus.setLastname(employee.getLastname());
		empstatus.setEmail(employee.getEmail());
		return empstatus;

}

	@Override
	public void delemp(long id) {
		
		employeerepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee"," Id", id) ) ;
		employeerepo.deleteById(id);
	}

	
}
