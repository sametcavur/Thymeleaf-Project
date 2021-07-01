package com.project.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.entity.Employee;
import com.project.repository.EmployeeRepository;

@Component(value = "employee")
public class EmployeeServicesImp implements EmployeeServices{
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		employeeRepository.delete(employee); 
		
	}

	@Override
	public Employee findEmployeeById(int employeeId) {
		Employee employee = employeeRepository.findById(employeeId).get();
		return employee;
	}

	@Override
	public List<Employee> findAllEmployees() {
		List<Employee> list = employeeRepository.findAll();
		return list;
	}
}
