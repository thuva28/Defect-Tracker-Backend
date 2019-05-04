package com.sgic.defecttracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sgic.defecttracker.model.Project;



public interface ProjectService {
	void saveProject(Project project);
	public List<Project> findAll();
	
	Project findProjectById(Long id);
	public void deleteProjectById(Long id);
	void updateProject(Project project);
	
}
