package com.online.flight.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.flight.entity.FlightEntity;
import com.online.flight.exception.FlightNotAvailableException;
import com.online.flight.exception.InvalidJourneyDateException;
import com.online.flight.exception.InvalidSourceDestinationException;
import com.online.flight.model.SearchFlights;
import com.online.flight.repository.FlightRepository;
import com.online.flight.utility.CalendarUtility;

@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepo;
	
	protected String baseUrl;
	
	public List<String> getSources(){
		List<String>  sources=flightRepo.findFlightSources();
		
		return sources;
	}
	
	public List<String> getDestinations(){
		List<String>  dest=flightRepo.findFlightDestinations();
		return dest;
		
	}

	public List<SearchFlights> getFlights(String source, String destination, Calendar journeyDate) throws InvalidJourneyDateException, InvalidSourceDestinationException, FlightNotAvailableException ,Exception {
		
		Calendar today=Calendar.getInstance();
		if(today.after(journeyDate)) throw new InvalidJourneyDateException("FlightService.INVALIDJOURNEYDATE");
		if(source.equalsIgnoreCase(destination))throw new InvalidSourceDestinationException("FlightService.Invalid_SOURCE_DESTINATION");
		
		List<FlightEntity> flights=flightRepo.findFlightDetails(source, destination, journeyDate);
		if(flights==null || flights.isEmpty())
		{
			throw new FlightNotAvailableException("FlightService.Flight_NOT_AVAILBALE");
			
		}
		List<SearchFlights> availableflights=new ArrayList<>();
		for(FlightEntity f : flights)
		{
		SearchFlights  flight= new SearchFlights();
		flight.setFlightId(f.getFlightId());
		flight.setSource(f.getSource());
		flight.setDestination(f.getDestination());
		flight.setFlightAvailableDate(CalendarUtility.getStringFromCalendar(f.getFlightAvailableDate()));
		flight.setDepartureTime(f.getDepartureTime());
		flight.setArrivalTime(f.getArrivalTime());
		flight.setSeatCount(f.getSeatCount().toString());
		flight.setAirlines(f.getAirlines());
		flight.setFare(Double.toString(f.getFare()));
		availableflights.add(flight);
		}
		return availableflights;
	}
	
}
