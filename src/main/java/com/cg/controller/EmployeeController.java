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
import org.springframework.web.client.RestTemplate;

import com.cg.entity.PaySlipEntity;
import com.cg.entity.employeeEntity;
import com.cg.repository.EmployeeRepository;
import com.netflix.discovery.EurekaClient;


@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
    private RestTemplate restTemplate;
	
    @Autowired
    private EurekaClient eurekaClient;
    
    @GetMapping("/communicate")
    public String getSalary() {
    	
        String url = "http://172.31.93.56:80" + "/payslip" + "/to";
        
        
        
        String payslip = restTemplate.getForObject(url, String.class);
                
		return payslip;
    }
	
	@GetMapping("/to")
	public String hello() {
		return "Hello student!!";
	}
	
	@GetMapping("/employees")
	public List<employeeEntity> EmployeeList(){
		return employeeRepository.findAll();
	}
	
	@PostMapping("/create")
	public employeeEntity createEmployee(@RequestBody employeeEntity employee) {
		return employeeRepository.saveAndFlush(employee);
	}
	
	@GetMapping("/get/{id}")
	public employeeEntity getById(@PathVariable Long id)
	{
		return employeeRepository.getOne(id);
	}
	
	@PutMapping("/update/{id}/{name}")
	public employeeEntity updateById(@PathVariable Long id, @PathVariable String name) {
		employeeEntity employee=employeeRepository.getOne(id);
		employee.setName(name);
		employeeRepository.saveAndFlush(employee);
		return employee;
	}
	
	@DeleteMapping("/delete/{id}")
	public employeeEntity deleteById(@PathVariable Long id) {
		employeeEntity employee=employeeRepository.getOne(id);
		employeeRepository.deleteById(id);
		return employee;
	}
}
