package com.mastek.training.hrapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.training.hrapp.apis.EmployeeService;
import com.mastek.training.hrapp.entities.Employee;

// @Component - indicate to Spring to create an object of this class
// @Scope - singleton: one object for application
// @Scope - prototype: one object for each usage

@RunWith(SpringRunner.class)
@SpringBootTest
@Scope("prototype")
public class ProjectApplicationTest {

	@Autowired
	EmployeeService empService;
	
	// @Autowired
	// Employee emp;
	
	@Test
	public void exampleProjectTest() {
		System.out.println("Project Test case Scenarios");
//		empService.registerOrUpdateEmployee(emp);
	}
}