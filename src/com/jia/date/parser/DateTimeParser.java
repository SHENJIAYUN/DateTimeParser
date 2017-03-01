package com.jia.date.parser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.jia.date.constant.Constant;
import com.jia.date.constant.WeekEnum;
import com.jia.date.utils.DateTimeUtil;

/**
 * 日期解析器
 * @author JIA
 * @version 1.0
 * @created 2017-02-12
 */
public class DateTimeParser {
	
	private DateFormat dateFormat = new SimpleDateFormat(Constant.dateFormat);
	private DateFormat dateTimeFormat = new SimpleDateFormat(Constant.dateTimeFormat);
	
	/**
	 * 获取当前日期
	 */
	public Date currentDate() {
		Calendar nowDate = Calendar.getInstance();
		return DateTimeUtil.stringToDate(dateFormat.format(nowDate.getTime()));
	}
	
	/**
	 * 获取当前时间日期
	 */
	public Date currentDateTime() {
		Calendar nowDate = Calendar.getInstance();
		return DateTimeUtil.stringToDateTime(dateTimeFormat.format(nowDate.getTime()));
	}
	
	/**
	 * 根据日期字符串构造日期
	 */
	public Date stringToDate(String dateString) {
		return DateTimeUtil.stringToDate(dateString);
	}
	
	/**
	 * 根据时间日期字符串构造日期
	 */
	public Date stringToDateTime(String dateTimeString) {
		return DateTimeUtil.stringToDateTime(dateTimeString);
	}
	
	/**
	 * 通过参数构造日期
	 */
	public Date createDate(int year, int month, int dayOfMonth) {
		Calendar calendar = new GregorianCalendar(year, month, dayOfMonth);
		return calendar.getTime();
	}
	
	/**
	 * 通过参数构造日期
	 */
	public Date createDate(int year, int month, int dayOfMonth, int hour, int minute) {
		Calendar calendar = new GregorianCalendar(year, month, dayOfMonth, hour, minute);
		return calendar.getTime();
	}
	
	/**
	 * 通过参数构造日期
	 */
	public Date createDate(int year, int month, int dayOfMonth, int hour, int minute, int second) {
		Calendar calendar = new GregorianCalendar(year, month, dayOfMonth, hour, minute, second);
		return calendar.getTime();
	}
	
	/**
	 * 获取年份
	 */
	public int getYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}
	
	/**
	 * 获取月份
	 */
	public int getMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH) + 1;
	}
	
	/**
	 * 获取日期
	 */
	public int getDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * 获取小时
	 */
	public int getHour(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * 获取分钟
	 */
	public int getMinute(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MINUTE);
	}
	
	/**
	 * 获取秒数
	 */
	public int getSecond(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.SECOND);
	}
	
	/**
	 * 获取某个月份的天数
	 */
	public int getDaysOfMonth(Date date) {
		Calendar calendar = DateTimeUtil.dateToCalendar(date);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * 获取两个日期的间隔天数
	 * @param beginDate
	 * @param endDate
	 * @return 相隔天数  
	 */
	public long getIntervalOfDate(Date beginDate, Date endDate) {
		long days = ((endDate.getTime()-beginDate.getTime()))/(24*60*60*1000);
		return days;
	}
	
	/**
	 * 某个日期的星期一
	 */
	private Date getMondayOfWeek(Date date) {
		Calendar calendar = DateTimeUtil.dateToCalendar(date);
		int dayInWeek = calendar.get(Calendar.DAY_OF_WEEK);
		int offset = 0;
		if(dayInWeek == 1) {
			offset = 6;
		} else {
			offset = dayInWeek - 2;
		}
		calendar.add(Calendar.DAY_OF_MONTH, -offset);
		return DateTimeUtil.calendarToDate(calendar);
	}
	
	/**
	 * 获取日期的某个星期
	 */
	public Date getDayOfWeek(Date date, WeekEnum dayOfWeek) {
		Date monday = getMondayOfWeek(date);
		Calendar calendar = DateTimeUtil.dateToCalendar(monday);
		switch (dayOfWeek) {
		case Monday:
			return monday;
		case Tuesday:
			calendar.add(Calendar.DAY_OF_MONTH, WeekEnum.Tuesday.ordinal());
			return DateTimeUtil.calendarToDate(calendar);
		case Wednesday:
			calendar.add(Calendar.DAY_OF_MONTH, WeekEnum.Wednesday.ordinal());
			return DateTimeUtil.calendarToDate(calendar);
		case Thursday:
			calendar.add(Calendar.DAY_OF_MONTH, WeekEnum.Thursday.ordinal());
			return DateTimeUtil.calendarToDate(calendar);
		case Friday:
			calendar.add(Calendar.DAY_OF_MONTH, WeekEnum.Friday.ordinal());
			return DateTimeUtil.calendarToDate(calendar);
		case Saturday:
			calendar.add(Calendar.DAY_OF_MONTH, WeekEnum.Saturday.ordinal());
			return DateTimeUtil.calendarToDate(calendar);
		case Sunday:
			calendar.add(Calendar.DAY_OF_MONTH, WeekEnum.Sunday.ordinal());
			return DateTimeUtil.calendarToDate(calendar);
		default:
			return null;
		}
	}
	
	/**
	 * 比较时间早晚
	 * @param date1
	 * @param date2
	 * @return -1: date1早于date2
	 * 			0: date1与date2相同
	 * 			1: date1晚于date2
	 */
	public int compareDate(Date date1, Date date2) {
		if(date1.before(date2)) {
			return -1;
		} else if(date1.after(date2)) {
			return 1;
		} else {
			return 0;
		}
	}
}
