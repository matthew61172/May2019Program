package com.mastek.training.hrapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table(name="JPA_DEPARTMENT")
@NamedQueries({
	@NamedQuery(name="Department.findByDeptLocation",query="select d from Department d where d.deptLocation = :location")
})
public class Department {
	@Value("-1")
	private int deptno;
	@Value("Default Department")
	private String deptName;
	@Value("Default Location")
	private String deptLocation;
	// One to many - One department has many Employees
	private Set<Employee> members = new HashSet<>();
	
	// @OneToMany is used on the get method to configure the association
	// FetchType.LAZY => delay the initialization until the get method is called using additional select query [default value]
	// FetchType.EAGER => Initialize the collection on the entity find (post load event)
	// CascadeType.ALL => Entity operations made on Department would be performed on each associated employee object
	// ALL = [Persist, Merge, Delete, Refresh]
	// mappedBy => Identifies the property name in the Child class where the Join Column config is present
	// Join Column = Foreign Key
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="currentDepartment")
	public Set<Employee> getMembers() {
		return members;
	}

	public void setMembers(Set<Employee> members) {
		this.members = members;
	}

	@Id
	@Column(name="department_number")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Column(name="department_name",nullable=false,length=60)
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	@Column(name="department_location",nullable=false,length=60)
	public String getDeptLocation() {
		return deptLocation;
	}

	public void setDeptLocation(String deptLocation) {
		this.deptLocation = deptLocation;
	}

}
