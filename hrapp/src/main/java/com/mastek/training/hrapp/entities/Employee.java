package com.mastek.training.hrapp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // One copy for each test case
@Entity // Declares the class as an Entity
@Table(name="JPA_EMPLOYEE") // Declaring the table name for the class
@EntityListeners({EmployeeLifecycleListener.class})
@NamedQueries({
	@NamedQuery(name="Employee.findBySalary",query="select e from Employee e where e.salary between :min and :max")
	
	
})
public class Employee implements Serializable { // Manage serialization 
	@Value("-1")
	private int empno;
	@Value("Default Employee")
	private String Name;
	@Value("100.0")
	private double Salary;
	
	public Employee() {
		System.out.println("Employee created");
	}
	
	@Id // Declare the property as Primary Key
	@Column(name="employee_number") // Declare the column name
	@GeneratedValue(strategy=GenerationType.AUTO) // Auto-numbering
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	
	@Column(name="Employee_name",nullable=false,length=45)
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	@Column(name="employee_salary")
	public double getSalary() { // JPA will default configurations - i.e. the double
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
