package com.somkod.employeemanager;

import java.util.List;

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

import com.somkod.employeemanager.model.Employee;
import com.somkod.employeemanager.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeResourse {
	
	private final EmployeeService employeeService;

	public EmployeeResourse(EmployeeService employeeService) {

		this.employeeService = employeeService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee () {
		List<Employee> employees = employeeService.findAllEmployees();
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Long id) {
		Employee employee = employeeService.findEmployeeById(id);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	@PostMapping("/add") 
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee newEmployee = employeeService.addEmployee(employee); 
		return new ResponseEntity<Employee>(newEmployee,HttpStatus.CREATED);
	}
	
	@PutMapping("/update") 
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee updateEmployee = employeeService.updateEmployee(employee); 
		return new ResponseEntity<Employee>(updateEmployee,HttpStatus.OK);
	}
	
	@DeleteMapping("/add") 
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
		employeeService.deleteEmployee(id); 
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}
	
	
}
