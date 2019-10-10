package com.online.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.flight.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity,String>{

	
	UserEntity findByuserId(String userId);

	
	

}

