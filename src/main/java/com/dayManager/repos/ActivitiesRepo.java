package com.dayManager.repos;

import com.dayManager.models.Activities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivitiesRepo extends JpaRepository <Activities, Integer>{

}
