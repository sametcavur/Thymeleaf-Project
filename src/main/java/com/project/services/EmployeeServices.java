package com.project.services;

import java.util.List;
import com.project.entity.Employee;

public interface EmployeeServices {

	public void addEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
	public Employee findEmployeeById(int employeeId);
	public List<Employee> findAllEmployees();
}
