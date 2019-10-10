package com.online.flight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.flight.entity.UserEntity;
import com.online.flight.exception.FlightInfoException;
import com.online.flight.exception.UserIdAlreadyPresentException;
import com.online.flight.model.User;
import com.online.flight.repository.UserRepository;

@Service
public class RegistrationService {

	@Autowired
	private UserRepository userRepo;

	
	public String registerUser(User user) throws FlightInfoException
	{
			
	boolean b=userRepo.existsById(user.getUserId());
	if(b)
		throw new UserIdAlreadyPresentException("RegistrationService.USERID_PRESENT");
		UserEntity userEntity=new UserEntity();
		userEntity.setCity(user.getCity());
		userEntity.setEmail(user.getEmail());
		userEntity.setName(user.getName());
		userEntity.setPassword(user.getPassword());
		userEntity.setPhone(user.getPhone());
		userEntity.setUserId(user.getUserId());
		userRepo.saveAndFlush(userEntity);
		return "UserRepository.REGISTRATION_SUCCESS";
	}

}
