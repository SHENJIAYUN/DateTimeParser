package com.jia.date.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.jia.date.constant.Constant;

/**
 * 日期工具类
 * @author JIA
 * @version 1.0
 * @created 2017-02-12
 */
public class DateTimeUtil {
	
	private static DateFormat dateFormat = new SimpleDateFormat(Constant.dateFormat);
	private static DateFormat dateTimeFormat = new SimpleDateFormat(Constant.dateTimeFormat);
	
	/**
	 * 字符串转换日期
	 */
	public static Date stringToDate(String dateString) {
		Date date = null;
		try {
			date =  dateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 字符串转换时间日期
	 */
	public static Date stringToDateTime(String dateTimeString) {
		Date date = null;
		try {
			date =  dateTimeFormat.parse(dateTimeString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 日期转化字符串
	 */
	public static String dateToString(Date date) {
		return dateFormat.format(date);
	}
	
	/**
	 * 时间日期转化字符串
	 */
	public static String dateTimeToString(Date date) {
		return dateTimeFormat.format(date);
	}
	
	/**
	 * 日期字符串转换Calendar
	 */
	public static Calendar dateStringToCalendar(String dateString) {
		Calendar calendar = Calendar.getInstance();
		try {
			Date date = dateFormat.parse(dateString);
			calendar.setTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return calendar;
	}
	
	/**
	 * 时间日期字符串转换Calendar
	 */
	public static Calendar dateTimeStringToCalendar(String dateTimeString) {
		Calendar calendar = Calendar.getInstance();
		try {
			Date date = dateTimeFormat.parse(dateTimeString);
			calendar.setTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return calendar;
	}
	
	/**
	 * Calendar转换日期字符串
	 */
	public static String calendarToDateString(Calendar calendar) {
		return dateFormat.format(calendar.getTime());
	}
	
	/**
	 * Calendar转换时间日期字符串
	 */
	public static String calendarToDateTimeString(Calendar calendar) {
		return dateTimeFormat.format(calendar.getTime());
	}
	
	/**
	 * Date转化Calendar
	 */
	public static Calendar dateToCalendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
	
	/**
	 * Calendar转化Date
	 */
	public static Date calendarToDate(Calendar calendar) {
		return calendar.getTime();
	}
}
