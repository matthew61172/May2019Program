package com.mastek.training.hrapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// @Component - Disable for form parameter processing

@Scope("prototype") // One copy for each test case
@Entity // Declares the class as an Entity
@Table(name="JPA_EMPLOYEE") // Declaring the table name for the class
@EntityListeners({EmployeeLifecycleListener.class})
@NamedQueries({
	@NamedQuery(name="Employee.findBySalary",query="select e from Employee e where e.salary between :min and :max")
})
// This config works for both XML and JSON
@XmlRootElement
public class Employee implements Serializable { // Manage serialization 
	@Value("-1")
	private int empno;
	@Value("Default Employee")
	// Name of parameters passed via HTML
	@FormParam("name")
	private String Name;
	@Value("100.0")
	@FormParam("salary")
	private double Salary;
	
	private Set<Project> assignments = new HashSet<>();
	
	// Many to one - Each employee belongs to one department
	private Department currentDepartment;
	
	// @ManyToMany => Configure the association for both the entities
	// @JoinTable => Provides all the config for the third table
	// name => Name of the join table
	// JoinColumns => Foreign key column names for current class
	// InverseJoinColumns => Foreign key column names for other class
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name="JPA_ASSIGNMENTS",joinColumns=@JoinColumn(name="FK_EMPNO"),inverseJoinColumns=@JoinColumn(name="FK_PROJECTID"))
	// Ignore the collections while using API
	@XmlTransient
	public Set<Project> getAssignments() {
		return assignments;
	}

	
	public void setAssignments(Set<Project> assignments) {
		this.assignments = assignments;
	}

	// @ManyToOne => Associating the Many class to One object
	// @JoinColumn => Configure the Foreign Key Column for association between the two entities
	@ManyToOne
	@JoinColumn(name="FK_DEPARTMENTNO")
	public Department getCurrentDepartment() {
		return currentDepartment;
	}

	public void setCurrentDepartment(Department currentDepartment) {
		this.currentDepartment = currentDepartment;
	}

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
