package com.dayManager.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayManager.models.Activities;
import com.dayManager.repos.ActivitiesRepo;

@Service
public class ActivitiesService {

	private ActivitiesRepo repo;
	
	@Autowired
	public ActivitiesService(ActivitiesRepo activityRepo) {
		this.repo = activityRepo;
	}
	
	@Transactional
	public Activities addActivity(Activities newActivity) {
		return repo.save(newActivity);
	}
	
	public List<Activities> getActivities() {
		return repo.findAll();
	}
	
}
