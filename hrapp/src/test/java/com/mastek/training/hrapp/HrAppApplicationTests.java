package com.mastek.training.hrapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.training.hrapp.apis.DepartmentService;
import com.mastek.training.hrapp.apis.EmployeeService;
import com.mastek.training.hrapp.apis.ProjectService;
import com.mastek.training.hrapp.entities.Department;
import com.mastek.training.hrapp.entities.Employee;
import com.mastek.training.hrapp.entities.Project;

// Initialize the JUnit test with Spring Boot application Environment
// Spring Boot test is used to test Spring ApplicationContext with all the test cases identified
@RunWith(SpringRunner.class)
@SpringBootTest
public class HrAppApplicationTests {

	// Scan in memory all the components and provide the best matching object in the component
	@Autowired
	EmployeeService empService;
	
/*	@Autowired
	Employee emp;*/

	@Autowired
	DepartmentService deptService;
	
/*	@Autowired
	Department dept;*/
	
	@Autowired
	ProjectService projService;
	
/*	@Autowired
	Project proj;*/
	
/*	@Test
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
	}*/
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
/*	@Test
	public void addOrUpdateDepartmentUsingService() {
		dept.setDeptno(0);
		dept.setDeptName("Finance");
		dept.setDeptLocation("Manchester");
		dept = deptService.registerOrUpdateDepartment(dept);
		assertNotNull(dept);
	}*/
	
/*	@Test
	public void checkFetchByDeptLocation() {
		List<Department> depts = deptService.fetchDepartmentsByLocation("Manchester");
		for (Department department : depts) {
			System.out.println(department);
		}
		assertEquals(depts.size(),2);
	}*/
	
/*	@Test
	public void findByEmpnoUsingService() {
		int deptno = 31;
		assertNotNull(deptService.findByDeptno(deptno));
	}
	
	@Test
	public void deleteByEmpnoUsingService() {
		int deptno = 31;
		deptService.deletebyDeptno(deptno);
		assertNull(deptService.findByDeptno(deptno));
	} */
	
////////////////////////////////////////////////////
	
/*	@Test
	public void addOrUpdateProjectUsingService() {
		proj.setProjId(0);
		proj.setProjName("Project X");
		proj.setCustName("Mick");
		proj = projService.registerOrUpdateProject(proj);
		assertNotNull(proj);
	}*/
/*	
	@Test
	public void findByProjIdUsingService() {
		int projId = 32;
		assertNotNull(projService.findByProjId(projId));
	}
	
	@Test
	public void deleteByProjIdUsingService() {
		int projId = 32;
		projService.deleteByProjId(projId);
		assertNull(projService.findByProjId(projId));
	}*/
	
/*	@Test
	public void checkFetchByDeptLocation() {
		List<Department> depts = deptService.fetchDepartmentsByLocation("Manchester");
		for (Department department : depts) {
			System.out.println(department);
		}
		assertEquals(depts.size(),2);
	}*/
	
/*	@Test
	public void checkFetchByProjCustomer() {
		List<Project> projs = projService.fetchProjectsByCustomer("Mick");
		for (Project project : projs) {
			System.out.println(project);
		}
		assertEquals(projs.size(),2);
	}*/

/*	@Test
	public void manageAssociations() {
		Department dept1 = new Department();
		dept1.setDeptName("Admin");
		dept1.setDeptLocation("UK");
		
		Employee emp1 = new Employee();
		emp1.setName("Admin Emp1");
		emp1.setSalary(213);
		
		Employee emp2 = new Employee();
		emp2.setName("Admin Emp2");
		emp2.setSalary(215);
		
		Project proj1 = new Project();
		proj1.setProjName("Project X");
		proj1.setCustName("Morrisons");
		
		Project proj2 = new Project();
		proj2.setProjName("Project Z");
		proj2.setCustName("Home Office");
		
		// One to Many
		dept1.getMembers().add(emp1);
		dept1.getMembers().add(emp2);
		
		// Many to One
		emp1.setCurrentDepartment(dept1);
		emp2.setCurrentDepartment(dept1);
		
		// Many to Many
		// emp1 works on two projects and emp2 only works on one. proj1 has two employees working on it.
		emp1.getAssignments().add(proj1);
		emp1.getAssignments().add(proj2);
		emp2.getAssignments().add(proj1);
		
		deptService.registerOrUpdateDepartment(dept1);
	}
	
	*/
	
/*	@Test
	public void assignDepartmentToEmployee() {
		int empno = 5;
		int deptno = 39;
		empService.assignDepartment(empno, deptno);
		Employee emp = empService.findByEmpno(7);
		assertNotNull(emp.getCurrentDepartment());
	} */
	
	@Test
	public void assignProjectToEmployee() {
		int empno = 9;
		int projId = 19;
		
		Set<Project> projs = empService.assignProject(empno,projId);
		
		assertNotNull(projs);
	}
	
}
