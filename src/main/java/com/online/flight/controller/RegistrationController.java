package com.online.flight.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.online.flight.exception.FlightInfoException;
import com.online.flight.exception.UserIdAlreadyPresentException;
import com.online.flight.model.User;
import com.online.flight.service.RegistrationService;

@Controller
public class RegistrationController {

	
	@Autowired 
	private Environment env;
	@Autowired
	private RegistrationService rs;
	
	private String command="command";
	private String register="register";
	
	@GetMapping("/register")
	public ModelAndView register(Model model)
	{
		return new ModelAndView(register,command,new User());
		
	}
	
	@PostMapping(value="registerUser")
	public ModelAndView addCustomer(@Valid @ModelAttribute("command") User user,BindingResult result,ModelMap model) throws FlightInfoException
	{
		ModelAndView md=new ModelAndView();
		if(result.hasErrors()) {
			md=new ModelAndView(register,command,user);
		}
		else {
			try {
				rs.registerUser(user);
				md=new ModelAndView(register,command,user);
				md.addObject("successMessage",env.getProperty("RegistrationController.SUCCESSFUL_REGISTRATION"));
			}catch(UserIdAlreadyPresentException e){
				if(e.getMessage().contains("RegistrationService"))
				{
					md=new ModelAndView(register);
					md.addObject(command, user);
					md.addObject("message", env.getProperty(e.getMessage()));
					
				}
			}
		}
		return md;
	}
	
	
}
