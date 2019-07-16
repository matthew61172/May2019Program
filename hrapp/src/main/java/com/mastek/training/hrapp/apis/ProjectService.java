package com.mastek.training.hrapp.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.training.hrapp.entities.Department;
import com.mastek.training.hrapp.entities.Project;
import com.mastek.training.hrapp.repositories.ProjectRepository;

@Component
@Scope("singleton")
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public ProjectService() {
		System.out.println("Project Service Created");
	}
	
	public Project registerOrUpdateProject(Project proj) {
		proj = projectRepository.save(proj);
		System.out.println("Employee Registered" + proj);
		return proj;
	}

	public Project findByProjId(int projId) {
		try {
			return projectRepository.findById(projId).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void deleteByProjId(int projId) {
		projectRepository.deleteById(projId);
	}
	
	public List<Project> fetchProjectsByCustomer(String customer){
        return projectRepository.findByProjCustomer(customer);
    }
}
