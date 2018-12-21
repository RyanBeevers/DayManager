package com.dayManager.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayManager.models.User;
import com.dayManager.repos.UserRepo;

@Service
public class UserService {

	private UserRepo repo;
	
	@Autowired
	public UserService(UserRepo userRepo) {
		this.repo = userRepo;
	}
	
	public User findUserByUsername (String username) {
		return repo.findUserByUsername(username);
	}
	
	@Transactional
	public User addUser(User newUser) {
		User temp = findUserByUsername(newUser.getUsername());
		if (temp != null) {
			return null;
		}
		return repo.save(newUser);
	}
	
}
