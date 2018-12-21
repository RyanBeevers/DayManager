package com.dayManager.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dayManager.models.Activities;
import com.dayManager.services.ActivitiesService;

@CrossOrigin("*")
@RestController
@RequestMapping("/home")
public class ActivitiesController {

	private ActivitiesService service;
	
	@Autowired
	public ActivitiesController (ActivitiesService activitiesService) {
		this.service = activitiesService;
	}
	
	@PostMapping(path="/add", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Activities> addActivity(@Valid @RequestBody Activities activity){
		if (activity == null) {
			return new ResponseEntity<>(activity, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(activity, HttpStatus.CREATED);
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Activities>> getActivities(){
		List<Activities> activities = service.getActivities();
		if (activities == null) {
			return new ResponseEntity<>(activities, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Activities>>(activities, HttpStatus.OK);
	}
	
}
