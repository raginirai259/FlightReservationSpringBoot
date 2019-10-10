<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body >

		<div class="container">
	
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4>Search Flights</h4>
					</div>
					<div class="panel-body">

	<form:form method="POST" action="searchFlights">
		<!-- SEARCH -->
<div class="container marginbottom-50">

			<div class="  col-sm-12 " >
				
		
						<div>
							<form:label path="source" class="control-label">Origin<span
									class="red">*</span>
							</form:label>
							<br>
							
							<form:select id="olist" path="source" class="form-control" required="true" title="Select source">
								
								 <form:option label="--Select  origin--" value=""/>
                                 <form:options items="${sourceList}"/> 
							</form:select>

							<br>
							<form:errors path="source" />
							<br>
						</div>


						<div>
							<form:label path="destination">Destination<span class="red">*</span>
							</form:label>
							<br>
						
							<form:select  path="destination"  required="true" title="Select destination">
							
								<form:option label="--Select  destination--" value=""/>
                                <form:options items="${destinationList}"/> 
							</form:select>
							<br>
							<form:errors path="destination" />
							<br>
						</div>


						<div>
							<form:label path="journeyDate" >Journey Date<span
									class="red">*</span>
							</form:label>
							<br>
							<form:input type="text"  path="journeyDate" required="true" title="Journey date is mandatory" />
							<br>
							<form:errors path="journeyDate" />
							<br>
						</div>




						<div>
							<br>
							<button type="submit"> Search Flights</button>
							<br>
						</div>

</div>
</div>
	</form:form>
            <div>${message}</div>  
          
					


	<c:if test="${size > 0}" >
		<div>

			<form:form method="POST" >
				<%!Random randomValue = new Random();%>

		<!-- for filter and results -->
		
						
					
				<div>Airlines</div>
				<div>
					<div>WingMeIn</div>
					<div><input type="checkbox" value="WingMeIn" id="air1" class="chk" name="airlines"/></div>
				</div>
				<div>
					<div >Aviate </div>
					<div ><input type="checkbox" value="Aviate" id="air2" class="chk" name="airlines"/></div>
				</div>						
				<div>
					<div >FlyWithMe</div>
					<div ><input type="checkbox" value="FlyWithMe" id="air3" class="chk" name="airlines"/></div>
				</div>
				<div ><hr class="darkgrey"/></div>	
				
				
				<div >
					<div >
						<div >
						</div>
						<div ></div>
					</div>
					
			
			<div  >
		
			
			
						<table id="flightDetails1" 
							style="width: 100%" hidden="hidden">

							<thead>
								<tr>
									<td ><b>Airline</b></td>	
								<td ><b>Departure Time</b></td>		
								<td ><b>Arrival Time</b></td>								
									<td><b> Seats</b></td>
									<td ><b>Fare(In Rs)</b></td>
									<td ><b>Book</b></td>
								</tr>
							</thead>
							<tbody>
						</tbody>
						</table>
		
		
			
					    <table id="flightDetails" class="display table  table-striped" style="width: 100%"
							>

							
							<tr>
									<td ><b>Airline</b></td>	
								<td ><b>Departure Time</b></td>		
								<td ><b>Arrival Time</b></td>								
									<td><b> Seats</b></td>
									<td ><b>Fare(In Rs)</b></td>
									<td ><b>Book</b></td>
								</tr>
							
							<tbody>
								<c:forEach var="flight" items="${availableFlights}">
									
									&nbsp;&nbsp;&nbsp;&nbsp;
									<tr>

										<td><form:label style="font-weight:300" path="airlines">${flight.airlines}-${flight.flightId} </form:label></td>
										<td><form:label style="font-weight:300" path="departureTime">${flight.departureTime}</form:label></td>	
										<td><form:label style="font-weight:300" path="departureTime">${flight.arrivalTime}</form:label></td>										
														
										<td><form:label style="font-weight:300" path="seatCount">${flight.seatCount}</form:label></td>
										<td><form:label style="font-weight:300" path="fare">${flight.fare}</form:label></td>
										<td>
										<a href="bookFlight?flightid=${flight.flightId}">Book</a></td>





									</tr>
								</c:forEach>
							</tbody>
						</table>
				
			</div>
			</div>
			</form:form>
			</div>
			</c:if>
</div>

	
				</div>
				</div>

	
							

		


	

</body>

</html>