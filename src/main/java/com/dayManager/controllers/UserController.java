package com.dayManager.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dayManager.models.User;
import com.dayManager.services.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/customers")
public class UserController {

	private UserService service;
	
	@Autowired
	public UserController (UserService userService) {
		this.service = userService;
	}
	
	@PostMapping(path="/register", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addUser(@Valid @RequestBody User newUser){
		User user = service.addUser(newUser);
		if (user == null) {
			return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@PostMapping(path="/login", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> login(@RequestBody User newUser){
		User user = service.findUserByUsername(newUser.getUsername());
		if (user == null) {
			return new ResponseEntity<>(user, HttpStatus.FORBIDDEN);
		}
		String password = newUser.getPassword();
		String password1 = user.getPassword();
		if(!password.equals(password1)) {
			return new ResponseEntity<>(user, HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
