package com.jia.date.test;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.jia.date.constant.WeekEnum;
import com.jia.date.parser.DateTimeParser;
import com.jia.date.utils.DateTimeUtil;

public class DateTest {

	DateTimeParser parser;
	Calendar calendar;
	
	@Before
	public void setUp() {
		parser = new DateTimeParser();
		calendar = Calendar.getInstance();
	}
	
	@Ignore
	public void test() {
		System.out.println(DateTimeUtil.calendarToDateString(calendar));
		System.out.println(DateTimeUtil.calendarToDateTimeString(calendar));
		String dateString = "2017-2-3 12:12:23";
		Date date = parser.stringToDateTime(dateString);
		System.out.println(DateTimeUtil.dateStringToCalendar(dateString).getTime());
		System.out.println(DateTimeUtil.dateTimeStringToCalendar(dateString).getTime());
		Date now = new Date();
		System.out.println(parser.getDaysOfMonth(date));
		System.out.println(parser.getIntervalOfDate(date, now));
		System.err.println(parser.getDayOfWeek(date, WeekEnum.Saturday));
		System.err.println(parser.getDayOfWeek(date, WeekEnum.Monday));
		System.err.println(parser.getDayOfWeek(date, WeekEnum.Friday));
		System.out.println(parser.compareDate(now, date));
	}
	
	@Test
	public void compare() {
		Date now = new Date();
		String dateString = "2017-2-14 12:12:23";
		Date date = parser.stringToDateTime(dateString);
		System.out.println(parser.compareDate(date, now));
	}

}
