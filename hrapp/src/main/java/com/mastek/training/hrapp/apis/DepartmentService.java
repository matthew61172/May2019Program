package com.mastek.training.hrapp.apis;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

import com.mastek.training.hrapp.entities.Department;
import com.mastek.training.hrapp.repositories.DepartmentRepository;

@Component
@Scope("singleton")
@Path("/departments/")
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Department registerOrUpdateDepartment(@BeanParam Department dept) {
		dept = departmentRepository.save(dept);
		System.out.println("Department Registered" + dept);
		return dept;
	}
	
	@Path("/find/{deptno}")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Department findByDeptno(@PathParam("deptno") int deptno) {
		try {
			return departmentRepository.findById(deptno).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
		
	@DELETE
	@Path("/delete/{deptno}")
	public void deletebyDeptno(@PathParam("deptno") int deptno) {
		departmentRepository.deleteById(deptno);
	}
	
	@GET
	@Path("/fetchByLocation")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Department> fetchDepartmentsByLocation(@QueryParam("location") String location){
        return departmentRepository.findByDeptLocation(location);
    }
}
