package com.online.flight.service;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.flight.entity.UserEntity;
import com.online.flight.exception.InvalidCredentialException;
import com.online.flight.model.Login;
import com.online.flight.model.User;
import com.online.flight.repository.UserRepository;

@Service
public class LoginService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User authenticateLogin(Login userlogin) throws InvalidCredentialException
	{
		UserEntity userEntity= userRepo.findByuserId(userlogin.getUserName());	
		
		User user=new User();
		
		user.setCity(userEntity.getCity());
		user.setEmail(userEntity.getEmail());
		user.setName(userEntity.getName());
		user.setPassword(userEntity.getPassword());
		user.setPhone(userEntity.getPhone());
		user.setUserId(userEntity.getUserId());
		
		if(user==null)
		{
			throw new InvalidCredentialException("LoginService.INVALID_CREDENTIALS");
		}else if(!(user.getPassword().equalsIgnoreCase(userlogin.getPassword()))) {	
			
			throw new InvalidCredentialException("LoginService.INVALID_CREDENTIALS");
		}
		
		return user;
	}
	

}
 