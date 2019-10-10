package com.online.flight.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtility {

	public static Calendar getCalenderFromString(String journeyDate) throws Exception{
		SimpleDateFormat smp=new SimpleDateFormat("yyyy-MM-dd");
		Date dtref=null;
		dtref=smp.parse(journeyDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(dtref);
		
		return cal;
	}

	public static String getStringFromCalendar(Calendar fightAvailableDate) throws Exception{
		Date dtref=null;
		SimpleDateFormat smp=new SimpleDateFormat("yyyy-MM-dd");
		dtref= fightAvailableDate.getTime();
		String textDate = smp.format(dtref);
		return textDate;
	}
	
	

}
