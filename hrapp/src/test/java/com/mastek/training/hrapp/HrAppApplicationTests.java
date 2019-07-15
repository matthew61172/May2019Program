package com.mastek.training.hrapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.List;

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
	public void addOrUpdateEmployeeUsingService() {
		emp.setEmpno(0);
		emp.setName("Emp1loyee");
		emp.setSalary(1123.33);
		emp = empService.registerOrUpdateEmployee(emp);
		assertNotNull(emp);
	}
	
	@Test
	public void findByEmpnoUsingService() {
		int empno = 1;
		assertNotNull(empService.findByEmpno(empno));
	}
	
	@Test
	public void deleteByEmpnoUsingService() {
		int empno = 29;
		empService.deleteByEmpno(empno);
		assertNull(empService.findByEmpno(empno));
	}
	
	
	@Test
	public void checkFetchBySalary() {
		List<Employee> emps = empService.fetchEmployeesBySalaryRange(0, 99);
		for (Employee employee : emps) {
			System.out.println(employee);
		}
		assertEquals(emps.size(),2);
	}

}
