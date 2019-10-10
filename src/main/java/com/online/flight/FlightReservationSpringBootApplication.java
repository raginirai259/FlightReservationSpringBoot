package com.online.flight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value= {"classpath:configuration.properties"})
public class FlightReservationSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightReservationSpringBootApplication.class, args);
	}

}
