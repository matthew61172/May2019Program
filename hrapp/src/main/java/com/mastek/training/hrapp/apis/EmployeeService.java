package com.mastek.training.hrapp.apis;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mastek.training.hrapp.entities.Department;
import com.mastek.training.hrapp.entities.Employee;
import com.mastek.training.hrapp.entities.Project;
import com.mastek.training.hrapp.repositories.DepartmentRepository;
import com.mastek.training.hrapp.repositories.EmployeeRepository;
import com.mastek.training.hrapp.repositories.ProjectRepository;

@Component
@Scope("singleton")
// Mapping the URL pattern with the class as service
@Path("/employees/")
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private ProjectService projectService;
	
	public EmployeeService() {
		System.out.println("Employee Service Created");
	}
	
	// HTTP Method to send form data
	@POST
	// URL pattern
	@Path("/register")
	// Form data
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	// JSON data
	@Produces(MediaType.APPLICATION_JSON)
	// Input bean using form
	public Employee registerOrUpdateEmployee(@BeanParam Employee emp) {
		emp = employeeRepository.save(emp);
		System.out.println("Employee Registered" + emp);
		return emp;
	}

	// Use the find method using PathParam
	@Path("/find/{empno}")
	// HTTP method used to call the API
	@GET
	// Declares all possible content types of the return value
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	// Use the PathParam as the argument for the method
	public Employee findByEmpno(@PathParam("empno") int empno) {
		try {
			return employeeRepository.findById(empno).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@DELETE
	@Path("/delete/{empno}")
	public void deleteByEmpno(@PathParam("empno") int empno) {
		employeeRepository.deleteById(empno);
	}
	
	@GET
	@Path("/fetchBySalary")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> fetchEmployeesBySalaryRange(@QueryParam("min") double min, @QueryParam("max") double max){
        return employeeRepository.findBySalary(min, max);
    }

	// To ensure that the DB session is open until all the operations in this method across repositories are completed
	// Initialized using lazy initialization
	@Transactional
	@POST
	@Path("/assign/department")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	// Use FormParam for associations as these will not be visible within the URL
	public Employee assignDepartment(@FormParam("empno") int empno, @FormParam("deptno") int deptno) {
		try {
			// Fetch the entities to be associated
			Employee emp = findByEmpno(empno);
			Department dept = departmentService.findByDeptno(deptno);
			// Manage the association
			dept.getMembers().add(emp);	// One assigned with many
			emp.setCurrentDepartment(dept);	// Many assigned with one
			// Update the entity to save the association
			registerOrUpdateEmployee(emp);
			return emp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Transactional
	@POST
	@Path("/assign/project")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Project> assignProject(@FormParam("empno") int empno, @FormParam("projId") int projId) {
		try {
			Employee emp = findByEmpno(empno);
			Project proj = projectService.findByProjId(projId);
			// Associate Employee with Project
			emp.getAssignments().add(proj);
			// Update the association in the DB, in join table
			emp = registerOrUpdateEmployee(emp);
			return emp.getAssignments();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
