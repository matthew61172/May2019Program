package com.mastek.training.hrapp.apis;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
// Create the Jersey Server config class
public class APIConfig extends ResourceConfig {
	
	public APIConfig() {
		// Register each service class in ResourceConfig
		register(EmployeeService.class);
		register(DepartmentService.class);
		register(ProjectService.class);
	}
}
