package com.mastek.training.hrapp.apis;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.training.hrapp.entities.Employee;

@Component
@Scope("singleton")
public class EmployeeService {

	public EmployeeService() {
		System.out.println("Employee Service Created");
	}
	
	public Employee registerEmployee(Employee emp) {
		System.out.println("Employee Registered" + emp);
		return emp;
	}
	
}
