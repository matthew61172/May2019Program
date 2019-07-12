package com.mastek.training.hrapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.training.hrapp.apis.EmployeeService;
import com.mastek.training.hrapp.entities.Employee;

// Initialize the JUnit test with Spring Boot application Environment
// Spring Boot test is used to test Spring ApplicationContext with all the test cases identified
@RunWith(SpringRunner.class)
@SpringBootTest
public class HrAppApplicationTests {

	// Scan in memory all the components and provide the best matching object in the component
	@Autowired
	EmployeeService empService;
	
	@Autowired
	Employee emp;	
	
	@Test
	public void addEmployeeUsingService() {
/*		Employee emp = new Employee();
		emp.setEmpno(1);
		emp.setName("Test");
		emp.setSalary(12.33);*/
		empService.registerEmployee(emp);
	}
	
	
	@Test
	public void simpleTest() {
		System.out.println("System Test Executed");
	}

}
