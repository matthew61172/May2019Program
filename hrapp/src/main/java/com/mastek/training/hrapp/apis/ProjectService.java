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

import com.mastek.training.hrapp.entities.Project;
import com.mastek.training.hrapp.repositories.ProjectRepository;

@Component
@Scope("singleton")
@Path("/projects/")
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public ProjectService() {
		System.out.println("Project Service Created");
	}
	
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Project registerOrUpdateProject(@BeanParam Project proj) {
		proj = projectRepository.save(proj);
		System.out.println("Employee Registered" + proj);
		return proj;
	}

	@GET
	@Path("/find/{projId}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Project findByProjId(@PathParam("projId") int projId) {
		try {
			return projectRepository.findById(projId).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@DELETE
	@Path("/delete/{projId}")
	public String deleteByProjId(@PathParam("projId") int projId) {
		try {
			projectRepository.deleteById(projId);
			String statement = projId + " deleted";
			return statement;
		} catch (Exception e) {
			String statement = "Project ID does not exist within DB";
			return statement;
		}
	}
	
	@GET
	@Path("/fetchByCustName")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Project> fetchProjectsByCustomer(@QueryParam("custName") String customer){
        return projectRepository.findByProjCustomer(customer);
    }
}
