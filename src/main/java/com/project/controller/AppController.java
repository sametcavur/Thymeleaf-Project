package com.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.entity.Employee;
import com.project.services.EmployeeServices;

@Controller
public class AppController {
	@Autowired
	@Qualifier(value = "employee")
	EmployeeServices employeeServices;

	@GetMapping(value = "/main")
	public String mainPage(Model model) {
		List<Employee> employees = employeeServices.findAllEmployees();
		model.addAttribute("employees", employees);
		return "/mainPage";
	}
	
	@GetMapping(value = "/addEmployee")
	public String addEmployeeGet(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "/addEmployee";
	}
	
	@PostMapping(value = "/addNewEmployee")
	public String addEmployeePost(Model model,@Valid @ModelAttribute("employee") Employee employee) {
			employeeServices.addEmployee(employee);
			return "redirect:/main";
		}

	@GetMapping(value = "/updateEmployee")
	public String updateEmployeeGet(@RequestParam("employeeidmiz") int employeeId,Model model) {
		Employee employee = employeeServices.findEmployeeById(employeeId);
		model.addAttribute("employee", employee);
		return "/addEmployee";
	}
	
	@GetMapping(value = "/deleteEmployee")
	public String deleteEmployeeGet(@RequestParam("employeeidmiz") int employeeId,Model model) {
		Employee employee = employeeServices.findEmployeeById(employeeId);
		employeeServices.deleteEmployee(employee);
		return "redirect:/main";
	}
}






