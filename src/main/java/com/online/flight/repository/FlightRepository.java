package com.online.flight.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.online.flight.entity.FlightEntity;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity,String>{
	
	@Query("select f from FlightEntity f where f.source=:source and f.destination=:dest and f.flightAvailableDate=:jdate and f.seatCount>0")
	List<FlightEntity> findFlightDetails(@Param("source") String source, @Param("dest") String destination,@Param("jdate") Calendar date);
     
	@Query("select distinct(f.source) from FlightEntity f")
	List<String> findFlightSources();

	@Query("select distinct(f.destination) from FlightEntity f")
	List<String> findFlightDestinations();

}
