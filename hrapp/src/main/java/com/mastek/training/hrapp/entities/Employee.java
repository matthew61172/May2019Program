package com.mastek.training.hrapp.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // One copy for each test case
public class Employee {
	@Value("-1")
	private int empno;
	@Value("Default Employee")
	private String Name;
	@Value("100.0")
	private double Salary;
	
	public Employee() {
		System.out.println("Employee created");
	}
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", Name=" + Name + ", Salary=" + Salary + "]";
	}
	
	
	
}
