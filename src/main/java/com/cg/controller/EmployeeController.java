package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.employeeEntity;
import com.cg.repository.EmployeeRepository;


@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/to")
	public String hello() {
		return "Hi Sir!!";
	}
	
	@GetMapping("/employees")
	public List<employeeEntity> EmployeeList(){
		List<employeeEntity> employeeList = employeeRepository.findAll();
		if(employeeList==null)
		return null;
		else
		return employeeList;
		
	}
	
	@PostMapping("/create")
	public employeeEntity createEmployee(@RequestBody employeeEntity employee) {
		employeeEntity employeee = employeeRepository.saveAndFlush(employee);
		if(employeee==null)
		return null;
		else
		return employee;
	}
	
	@GetMapping("/get/{id}")
	public employeeEntity getById(@PathVariable Long id)
	{
		employeeEntity employee = employeeRepository.getOne(id);
		if(employee == null)
			return null;
		else
		return employee;
	}
	
	@PutMapping("/update/{id}/{name}")
	public employeeEntity updateById(@PathVariable Long id, @PathVariable String name) {
		employeeEntity employee=employeeRepository.getOne(id);
		if(employee!=null) {
		employee.setName(name);
		employeeRepository.saveAndFlush(employee);
		}
		return employee;
	}
	
	@DeleteMapping("/delete/{id}")
	public employeeEntity deleteById(@PathVariable Long id) {
		employeeEntity employee=employeeRepository.getOne(id);
		if(employee!=null)
		employeeRepository.deleteById(id);
		return employee;
	}
}
