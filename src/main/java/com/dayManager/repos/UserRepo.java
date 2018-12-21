package com.dayManager.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dayManager.models.User;

@Repository
public interface UserRepo extends JpaRepository <User, Integer>{
	
	User findUserByUsername(String username);
	
}
