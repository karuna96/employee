package com.cg.employeee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.controller.EmployeeController;
import com.cg.entity.employeeEntity;
import com.cg.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
public class EmployeeControllerTest {

	@InjectMocks
	EmployeeController employeeController;
	
	@Mock
	EmployeeRepository employeeRepository;
	
	@Test
	public void employeeListTest() {
		Mockito.when(this.employeeRepository.findAll()).thenReturn(this.getEmployeeList());
		
		assertNotNull(this.employeeController.EmployeeList());
	}
	
	@Test
	public void createEmployeeTest() {
		Mockito.when(this.employeeRepository.saveAndFlush(this.getEmployee())).thenReturn(this.getEmployee());
		
		assertEquals(null, this.employeeController.createEmployee(this.getEmployee()));
	}
	
	@Test
	public void getByIdTest() {
		Mockito.when(this.employeeRepository.getOne(1L)).thenReturn(this.getEmployee());
		
		assertNotNull(this.employeeController.getById(1L));
	}
	
	@Test
	public void updateByIdTest() {
		Mockito.when(this.employeeRepository.saveAndFlush(Mockito.any())).thenReturn(this.getEmployee());
		Mockito.when(this.employeeRepository.getOne(1L)).thenReturn(this.getEmployee());
		
		assertNotNull( this.employeeController.updateById(1L, "Gowthami"));
	}
	
	@Test
	public void deleteByIdTest() {
		Mockito.when(this.employeeRepository.getOne(1L)).thenReturn(this.getEmployee());
		
		assertNotNull(this.employeeController.deleteById(1L));
	}
	
	@Test
	public void helloTest() {
		assertNotNull(this.employeeController.hello());
	}
	
	private List<employeeEntity> getEmployeeList(){
		List<employeeEntity> employeeList = new ArrayList<>();
		
		employeeEntity employee = this.getEmployee();
		
		employeeList.add(employee);
		
		return employeeList;
	}
	
	private employeeEntity getEmployee() {
		employeeEntity employee = new employeeEntity();
		employee.setId(1L);
		employee.setName("Gowthami");
		return employee;
		
	}
}
