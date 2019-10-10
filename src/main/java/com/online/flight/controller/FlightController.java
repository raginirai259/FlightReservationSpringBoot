package com.online.flight.controller;

import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.online.flight.exception.FlightNotAvailableException;
import com.online.flight.exception.InvalidCredentialException;
import com.online.flight.exception.InvalidJourneyDateException;
import com.online.flight.exception.InvalidSourceDestinationException;
import com.online.flight.model.Login;
import com.online.flight.model.SearchFlights;
import com.online.flight.model.User;
import com.online.flight.service.FlightService;
import com.online.flight.utility.CalendarUtility;

@Controller
public class FlightController {

	
	@Autowired
	private FlightService flightServe;
	
	@Autowired
	private Environment env;
	
	@PostMapping("/searchFlights")
	public ModelAndView searchFlights(@Valid @ModelAttribute("command") SearchFlights searchFlights,BindingResult result,ModelMap model) throws Exception
	 {
		 ModelAndView mv=null;
		 try {
			 if(result.hasErrors())
			 {
				 mv=new ModelAndView("searchFlights","command",searchFlights);
			 }
			 else
			 {
				 String source=searchFlights.getSource();
				 String destination=searchFlights.getDestination();
				 Calendar journeyDate=CalendarUtility.getCalenderFromString(searchFlights.getJourneyDate());
				 List<SearchFlights> availableFlights=flightServe.getFlights(source,destination,journeyDate);
				 model.addAttribute("availableFlights", availableFlights);
				 model.addAttribute("size", availableFlights.size());
				 mv=new ModelAndView("searchFlights","command",searchFlights);
			 }
		 }catch(FlightNotAvailableException | InvalidJourneyDateException  | InvalidSourceDestinationException e)
		 {
			 if(e.getMessage().contains("FlightService")) {
				 mv=new ModelAndView("searchFlights");
				}
			 mv.addObject("message", env.getProperty(e.getMessage()));
			 
		 }
		 
		 List<String> s1=flightServe.getSources();
		 model.addAttribute("sourceList", s1);
		 List<String> s2=flightServe.getDestinations();
		 model.addAttribute("destinationList", s2);
		return mv;
	 }
	 
	
}
