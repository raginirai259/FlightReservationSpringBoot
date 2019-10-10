package com.online.flight.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.online.flight.exception.InvalidCredentialException;
import com.online.flight.model.Login;
import com.online.flight.model.SearchFlights;
import com.online.flight.model.User;
import com.online.flight.service.FlightService;
import com.online.flight.service.LoginService;

@Controller
@SessionAttributes({"userName","userId"})
public class LoginController {
	
	@Autowired
	private LoginService loginserve;
	
	@Autowired
	private FlightService flightServe;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/login")
	public ModelAndView getLoginDetails() {
		return new ModelAndView("login","command",new Login());
	}
	 @PostMapping("/authenticateLogin")
	 public ModelAndView authenticateLogin(@Valid @ModelAttribute("command") Login userLogin,BindingResult result,ModelMap model)
	 {
		 ModelAndView mv=new ModelAndView("error");
		 try {
			 if(result.hasErrors())
			 {
				 mv=new ModelAndView("login","command",userLogin);
			 }
			 else
			 {
				 User user=loginserve.authenticateLogin(userLogin);
				 model.addAttribute("userName", user.getName());
				 model.addAttribute("userId", user.getUserId());
				 List<String> s1=flightServe.getSources();
				 model.addAttribute("sourceList", s1);
				 List<String> s2=flightServe.getDestinations();
				 model.addAttribute("destinationList", s2);
				 mv=new ModelAndView("searchFlights","command",new SearchFlights());
			 }
		 }catch(InvalidCredentialException e)
		 {
			 if(e.getMessage().contains("LoginService")) {
				 mv=new ModelAndView("login");
				 mv.addObject("loginName", userLogin.getUserName());
			 }
			 mv.addObject("message", env.getProperty(e.getMessage()));
			 
		 }
		return mv;
	 }
	 

}
