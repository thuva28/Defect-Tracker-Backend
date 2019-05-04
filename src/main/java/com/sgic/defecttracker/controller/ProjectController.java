
package com.sgic.defecttracker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.defecttracker.exception.ResourceNotFoundException;
import com.sgic.defecttracker.model.Defect;
import com.sgic.defecttracker.model.Project;
import com.sgic.defecttracker.service.ProjectService;


@RestController
@RequestMapping("/project")
@CrossOrigin(origins = "http://localhost:3000")
public class ProjectController {

@Autowired
ProjectService projectService;
	
   

	@PostMapping("/save")
	public HttpStatus createProject(@Valid @RequestBody Project project) {
		projectService.saveProject(project);
		return HttpStatus.CREATED;
	}
	

	@GetMapping("/getall")
	public List<Project> findProject(Project project){
		List<Project> moduless = (List<Project>) projectService.findAll();
		 return moduless;
	}
	
	@GetMapping("getProjectById/{id}")
	public Project getProjectById(@PathVariable("id") Long id) {
		Project getProject = projectService.findProjectById(id);
		return getProject;
	}
	
	@PutMapping("/updateProject/{id}")
	public ResponseEntity<Project> updateProject(@Valid @RequestBody Project project){
		projectService.updateProject(project);
		return new ResponseEntity<Project>(project, HttpStatus.NO_CONTENT);
		
	}
	@DeleteMapping("deleteProject/{id}")
	public void deleteProjectById(@PathVariable("id") Long id) {
		projectService.deleteProjectById(id);
		
	}

}

	

	
	

	
