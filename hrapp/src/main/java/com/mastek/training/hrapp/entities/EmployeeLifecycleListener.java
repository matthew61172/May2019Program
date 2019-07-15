package com.mastek.training.hrapp.entities;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class EmployeeLifecycleListener {
	// Life cycle methods
	// @<Event>
	// public void <name>(Entity e)
	
	@PrePersist
	public void beforeInsert(Employee e) {
		System.out.println("Before Insert: " + e);
	}
	
	@PostPersist
	public void afterInsert(Employee e) {
		System.out.println("After Insert: " + e);
	}
	
	@PreUpdate
	public void beforeUpdate(Employee e) {
		System.out.println("Before update: " + e);
	}
	
	@PostUpdate
	public void afterUpdate(Employee e) {
		System.out.println("After update: " + e);
	}
	
	@PreRemove
	public void beforeDelete(Employee e) {
		System.out.println("Before delete: " + e);
	}
	
	@PostLoad
	public void afterDelete(Employee e) {
		System.out.println("After delete: " + e);
	}
	
}
