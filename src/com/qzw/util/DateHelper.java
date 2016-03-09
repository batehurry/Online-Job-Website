package com.qzw.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DateHelper {
	
	private DateHelper() {
		
	}
	
	/**
	 * 将指定的字符串转换成yyyy-MM-dd HH:mm格式的Timestamp对象
	 * @param source 装换的字符串
	 * @return
	 */
	public static Timestamp getformatTimestamp(String source){
		return formatToTimestamp(source,"yyyy-MM-dd HH:mm");
	}
	
	/**
	 * 查询当前时间
	 * @return 当前时间
	 */
	public static Timestamp getCurrentTime() {
		Date date = new Date();
		return new Timestamp(date.getTime());
	}
	
	/**
	 * 根据格式将时间字符串转换成对应的Timestamp对象
	 * @param source 需要转换的字符串
	 * @param format 格式
	 * @return
	 */
	public static Timestamp formatToTimestamp(String source,String format) {
		Timestamp target = null;
		
		try {
			if(source != null && !"".equals(source.trim())) {
				SimpleDateFormat dateFormat = new SimpleDateFormat(format);
				target = new Timestamp(dateFormat.parse(source).getTime());
			}
		} catch (ParseException e) {
		}  
		
		return target;
	}
	
	/**
	 * 在当前时间上根据时间类型增加和减少相应的时间;
	 * 		例如：将当前的时间的日期加一天，changeTimestamp(source,"day",-1)
	 * @param source 当前时间
	 * @param timeType 时间类型
	 * @param forwordLen 增加和减少的数值
	 * @return Timestamp对象
	 */
	public static Timestamp changeTimestamp(Timestamp source,String timeType,int forwordLen) {
		if(source != null) {
			Calendar targetCal = Calendar.getInstance();
			targetCal.setTime(source);
			
			return convertTimestamp(targetCal, timeType, forwordLen);
		}
		else {
			return null;
		}
	}
	
	/**
	 * 在当前时间上根据时间类型增加和减少相应的时间;
	 * 		例如：将当前的时间的日期加一天，changeTimestamp(source,"day",-1)
	 * @param source 当前时间
	 * @param timeType 时间类型
	 * @param forwordLen 增加和减少的数值
	 * @return Timestamp对象
	 */
	public static Timestamp forwordTimestamp(Timestamp source,String timeType,int forwordLen) {
		if(source != null) {
			Calendar targetCal = Calendar.getInstance();
			targetCal.setTime(source);
			
			return forwordTimestamp(targetCal, timeType, forwordLen);
		}
		else {
			return null;
		}
	}
	/**
	 * 在当前时间上根据时间类型增加和减少相应的时间;
	 * 		例如：将当前的时间的日期加一天，changeTimestamp(source,"day",-1)
	 * @param source 当前时间
	 * @param timeType 时间类型
	 * @param forwordLen 增加和减少的数值
	 * @return Timestamp对象
	 */
	public static Timestamp forwordTimestamp(String timeType,int forwordLen) {
		Calendar targetCal = Calendar.getInstance();
		return forwordTimestamp(targetCal, timeType, forwordLen);
	}
	
	/**
	 * 将指定的时间转换成指定的格式
	 * @param source 指定的时间
	 * @param format 指定的格式
	 * @return 时间字符串
	 */
	public static String parseDate(Date source,String format) {
		String target = null;
		
		try {
			if(source != null) {
				SimpleDateFormat dateFormat = new SimpleDateFormat(format);
				target = dateFormat.format(source);
			}
		} catch (Exception e) {
		}
		
		return target;
	}
	
	/**
	 * 将指定的时间转换成"yyyy-MM-dd HH:mm"格式的字符串
	 * @param source 指定的时间
	 * @return 字符串
	 */
	public static String getParseDate(Date source) {
		return parseDate(source,"yyyy-MM-dd HH:mm");
	}
	
	/**
	 * 根据时间类型查找当前指定类型的开始时间
	 * @param timeType 'day：查询当天
	 * 					'week'：查询本周
	 * 					'month'：查询本月
	 * @param forwordLen 前几
	 * @return 转换的时间
	 */
	public static Timestamp getBeginTime(String timeType,int forwordLen) {
		Calendar beginCal = Calendar.getInstance();
		return convertTimestamp(beginCal, timeType, forwordLen);
	}
	
	/**
	 * 根据时间类型查找当前指定类型的开始时间
	 * @param timeType 'day：查询当天
	 * 					'week'：查询本周
	 * 					'month'：查询本月
	 * @return 转换的时间
	 */
	public static Timestamp getBeginTime(String timeType) {
		return getBeginTime(timeType,0);
	}
	
	/**
	 * 根据时间类型查找当前指定类型的开始时间字符串
	 * @param timeType 'day：查询当天
	 * 					'week'：查询本周
	 * 					'month'：查询本月
	 * @return 转换的时间字符串
	 */
	public static String getBeginStr(String timeType) {
		return getBeginStr(timeType,0);
	}
	
	/**
	 * 根据时间类型查找当前指定类型的开始时间
	 * @param timeType 'day：查询当天
	 * 					'week'：查询本周
	 * 					'month'：查询本月
	 * @param forwordLen 前几
	 * @return 转换的时间字符串
	 */
	public static String getBeginStr(String timeType,int forwordLen) {
		return getBeginStr(timeType,forwordLen,"yyyy-MM-dd HH:mm");
	}
	
	/**
	 * 根据时间类型查找当前指定类型的开始时间
	 * @param timeType 'day：查询当天
	 * 					'week'：查询本周
	 * 					'month'：查询本月
	 * @param forwordLen 前几
	 * @param format 时间格式
	 * @return 转换的时间字符串
	 */
	public static String getBeginStr(String timeType,int forwordLen,String format) {
		return parseDate(getBeginTime(timeType,forwordLen),format);
	}
	
	/**
	 * 将指定的calendar对象，根据时间类型和增加减少的数值，转换成对应时间
	 * @param calendar Calendar对象
	 * @param timeType 时间类型
	 * @param forwordLen 增加减少的数值
	 * @return Timestamp对象
	 */
	public static Timestamp forwordTimestamp(Calendar calendar,String timeType,int forwordLen) {
		//获取当前日期
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		
		if("week".equalsIgnoreCase(timeType)) {
			day -= forwordLen*7;
		}
		else if("month".equalsIgnoreCase(timeType)) {
			//指定的月份
			month -= forwordLen;
		}
		else if("day".equalsIgnoreCase(timeType)) {
			//指定的日期
			day -= forwordLen;
		}
		else if("hour".equalsIgnoreCase(timeType)) {
			hour -= forwordLen;
		}
		else if("minute".equalsIgnoreCase(timeType)) {
			minute -= forwordLen;
		}
		else if("second".equalsIgnoreCase(timeType)) {
			second -= forwordLen;
		}
		
		//构造指定的日期
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH,month);
		calendar.set(Calendar.DAY_OF_MONTH,day);
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE,minute);
		calendar.set(Calendar.SECOND,second);
		
		return new Timestamp(calendar.getTime().getTime());
	}
	
	/**
	 * 将指定的calendar对象，根据时间类型和增加减少的数值，转换成对应时间
	 * @param calendar Calendar对象
	 * @param timeType 时间类型
	 * @param forwordLen 增加减少的数值
	 * @return Timestamp对象
	 */
	private static Timestamp convertTimestamp(Calendar calendar,String timeType,int forwordLen) {
		//获取当前日期
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);

		if("week".equalsIgnoreCase(timeType)) {
			//如果是今天是周末，传入值加1，查找此周的周一
			if(calendar.get(Calendar.DAY_OF_WEEK) == 1) {
				day -= (6 + forwordLen*7);
			}
			else {
				day -= (calendar.get(Calendar.DAY_OF_WEEK) - 2 + forwordLen*7);
			}
			hour = 0;
			minute = 0;
			second = 0;
		}
		else if("month".equalsIgnoreCase(timeType)) {
			//指定的月份
			month -= forwordLen;
			day = 1;
			hour = 0;
			minute = 0;
			second = 0;
		}
		else if("day".equalsIgnoreCase(timeType)) {
			//指定的日期
			day -= forwordLen;
			hour = 0;
			minute = 0;
			second = 0;
		}
		else if("hour".equalsIgnoreCase(timeType)) {
			//指定小时
			hour -= forwordLen;
			minute = 0;
			second = 0;
		}
		else if("minute".equalsIgnoreCase(timeType)) {
			//指定分钟
			minute -= forwordLen;
			second = 0;
		}
		else if("second".equalsIgnoreCase(timeType)) {
			//指定秒数
			second -= forwordLen;
		}
		
		//构造指定的日期
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH,month);
		calendar.set(Calendar.DAY_OF_MONTH,day);
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE,minute);
		calendar.set(Calendar.SECOND,second);
		
		return new Timestamp(calendar.getTime().getTime());
	}
	
	/**
	 * 取得30天以前的时间,以Timestamp类型返回
	 * @param source 原时间
	 * @return 30天以前的时间
	 */
	public static Timestamp getMonthAgoToTimstamp(Timestamp source){
		return changeTimestamp(source, "day", 30);
	}
	
	/**
	 * 取当前时间后forwordLen天，forwordLen > 0 此时间之前，forwordLen < 0 此时间之后,以00:00:00计时
	 * @param source Timestamp对象
	 * @param forwordLen 多少天前
	 * @return Timestamp对象
	 */
	public static Timestamp getForwordDayTime(Timestamp source,int forwordLen) {
		return changeTimestamp(source, "day", forwordLen);
	}
	
	/**
	 * 取得30天以前的时间,以字符串类型返回,例如(2010-10-10)
	 * @param source 原时间
	 * @return 30天以前的时间
	 */
	public static String getMonthAgoToDayString(Timestamp source) {
		return getMonthAgoToString(source,"yyyy-MM-dd");
	}
	
	/**
	 * 取得30天以前的时间,以字符串类型返回
	 * @param source 原时间
	 * @return 30天以前的时间
	 */
	public static String getMonthAgoToString(Timestamp source,String farmat) {
		Timestamp targetTime = changeTimestamp(source, "day", 30);
		
		String timeStr = parseDate(targetTime, farmat);
		
		return timeStr;
	}
	
	/**
	 * 取得当前的时间,以dayCode字符串类型返回,例如(20101010)
	 * @param source 原时间
	 * @return当前的时间
	 */
	public static String getMonthAgoToDayCode2(Timestamp source){
		String timeStr = parseDate(source, "yyyy-MM");
		
		if(timeStr != null) {
			return timeStr.replace("-", "");
		}
		
		return  null;
	}
	/**
	 * 取得30天以前的时间,以dayCode字符串类型返回,例如(20101010)
	 * @param source 原时间
	 * @return 30天以前的时间
	 */
	public static String getMonthAgoToDayCode(Timestamp source){
		String timeStr = getMonthAgoToString(source, "yyyy-MM-dd");
		
		if(timeStr != null) {
			return timeStr.replace("-", "");
		}
		
		return  null;
	}
	/**
	 * 将Timestamp格式的时间，转换策划那个以dayCode字符串类型的格式返回，例如(20101010)
	 * @param source 原时间
	 * @return dayCode字符按
	 */
	public static String parseTimestampToDayCode(Timestamp source) {
		String timeStr = parseDate(source, "yyyy-MM-dd");
		
		if(timeStr != null) {
			return timeStr.replace("-", "");
		}
		
		return null;
	}
	
	/**
	 * 取得今天的时间,以dayCode字符串类型返回
	 * @return 今天
	 */
	public static String getNowToDayCode(){
		String timeStr = getNowToDayString();
		
		if(timeStr != null) {
			return timeStr.replace("-", "");
		}
		
		return null;
	}
	
	/**
	 * 取得今天的时间,以字符串类型返回
	 * @param format 时间格式
	 * @return 今天时间字符串
	 */
	public static String getNowToString(String format){
		return parseDate(getNowTime(), format);
	}
	
	/**
	 * 取得今天的时间,以字符串类型返回,例如(20101010)
	 * @param format 时间格式
	 * @return 今天时间字符串
	 */
	public static String getNowToDayString(){
		return getNowToString("yyyy-MM-dd");
	}
	
	/**
	 * 取得当天的开始时间
	 * @return Timestamp对象
	 */
	public static Timestamp getNowDayTime(){
		return getBeginTime("day", 0);
	}
	
	/**
	 * 取得当天的开始时间字符串
	 * @return 当天开始时间字符串
	 */
	public static String getNowDayStr(){
		return getNowDayStr("yyyy-MM-dd HH:mm");
	}
	
	/**
	 * 取得当天开始时间字符串
	 * @param formart 时间格式
	 * @return 时间字符串
	 */
	public static String getNowDayStr(String formart){
		return parseDate(getNowDayTime(), formart);
	}
	
	/**
	 * 获取当前时间
	 * @return 当前时间
	 */
	public static Timestamp getNowTime(){
		Date date = new Date();
		
		return new Timestamp(date.getTime());
	}
	
	/**
	 * 取得当前时间字符串
	 * @return 时间字符串
	 */
	public static String getNowStr(){
		return getNowStr("yyyy-MM-dd HH:mm");
	}
	
	/**
	 * 取得当前时间字符串
	 * @param formart 时间格式
	 * @return 时间字符串
	 */
	public static String getNowStr(String format){
		Date date = new Date();
		
		return parseDate(date, format);
	}
	
	/**
	 * 取得本周的开始时间
	 * @return Timestamp对象
	 */
	public static Timestamp getNowWeekTime(){
		return getBeginTime("week", 0);
	}
	
	/**
	 * 取得本月的开始时间字符串
	 * @return 时间字符串
	 */
	public static String getNowWeekStr(){
		return getNowWeekStr("yyyy-MM-dd HH:mm");
	}
	
	/**
	 * 取得本周的开始时间字符串
	 * @param formart 时间格式
	 * @return 时间字符串
	 */
	public static String getNowWeekStr(String formart){
		return parseDate(getNowWeekTime(), formart);
	}
	
	/**
	 * 取得本月的开始时间
	 * @return Timestamp对象
	 */
	public static Timestamp getNowMonthTime(){
		return getBeginTime("month", 0);
	}
	
	/**
	 * 取得本月的开始时间字符串
	 * @return 时间字符串
	 */
	public static String getNowMonthStr(){
		return getNowMonthStr("yyyy-MM-dd HH:mm");
	}
	
	/**
	 * 取得本月的开始时间字符串
	 * @param formart 时间格式
	 * @return 时间字符串
	 */
	public static String getNowMonthStr(String formart){
		return parseDate(getNowMonthTime(), formart);
	}
	
	/**
	 * 取得forwordLen天以前的开始时间，以00:00:00计
	 * 		forwordLen > 0 向前查找 例：今天18号，forwordLen = 1， 返回应是17号
	 * 		forwordLen = 0 当天的时间
	 * 		forwordLen < 0 向后查找 例：今天18号，forwordLen = -1， 返回应是19号
	 * @return Timestamp对象
	 */
	public static Timestamp getForwordDayTime(int forwordLen){
		return getBeginTime("day", forwordLen);
	}
	
	/**
	 * 取得forwordLen周以前的开始时间，以00:00:00计
	 * 		forwordLen > 0 向前查找 例：本周18周，forwordLen = 1， 返回应是17周
	 * 		forwordLen = 0 本周的时间
	 * 		forwordLen < 0 向后查找 例：本周18周，forwordLen = -1， 返回应是19周
	 * @return Timestamp对象
	 */
	public static Timestamp getForwordWeekTime(int forwordLen){
		return getBeginTime("week", forwordLen);
	}
	
	/**
	 * 取得forwordLen月以前的开始时间，以00:00:00计
	 * 		forwordLen > 0 向前查找 例：本月10月，forwordLen = 1， 返回应是9月
	 * 		forwordLen = 0 本月的时间
	 * 		forwordLen < 0 向后查找 例：本月10月，forwordLen = -1， 返回应是11月
	 * @return Timestamp对象
	 */
	public static Timestamp getForwordMonthTime(int forwordLen){
		return getBeginTime("month", forwordLen);
	}
	
	/**
	 * 根据日期格式将日期编号转换成对应的日期字符串（支持年月日）
	 * @param dateCode 日期编号
	 * @param formart 日期类型
	 * @param delPreZorn 是否删除月和日前面一个0
	 * @return 日期描述
	 */
	public static String getDateCodeToDesc(String dateCode,String formart,boolean delPreZorn) {
		String dateStr = formart;
		
		try {
			if(formart.contains("yyyy")) {
				
				//取得年份字符串，并裁出年份
				String year = dateCode.substring(0, 4);
				dateCode = dateCode.substring(4);
				
				//替换对应的年份字符
				dateStr = dateStr.replace("yyyy", year);
			}
			
			if(formart.contains("MM")) {
				
				//取得月份字符串，并裁处月份
				String month = dateCode.substring(0,2);
				
				//删除前置0
				if(delPreZorn) {
					Integer mInt = Integer.parseInt(month);
					month = mInt + "";
				}
				
				dateCode = dateCode.substring(2);
				
				//替换对应的月份字符
				dateStr = dateStr.replace("MM", month);
			}
			
			if(formart.contains("dd")) {
				
				//取得月份字符串，并裁处月份
				String day = dateCode.substring(0,2);
				
				//删除前置0
				if(delPreZorn) {
					Integer dInt = Integer.parseInt(day);
					day = dInt + "";
				}
				
				dateCode = dateCode.substring(1);
				
				//替换对应的日期字符
				dateStr = dateStr.replace("dd", day);
			}
		} catch (NumberFormatException e) {
			dateStr = null;
		}
		
		return dateStr;
	}
	
	/**
	 * 根据月编号取得日期对应的字符串
	 * @param dateCode 日期编号
	 * @return 日期字符串
	 */
	public static String getMonthDesc(String dateCode) {
		return getDateCodeToDesc(dateCode, "yyyy年MM月", true);
	}
	
	/**
	 * 根据天编号取得日期对应的字符串
	 * @param dateCode 日期编号
	 * @return 日期字符串
	 */
	public static String getDayDesc(String dateCode) {
		return getDateCodeToDesc(dateCode, "yyyy年MM月dd日", true);
	}
	
	/**
	 * 根据年编号取得日期对应的字符串
	 * @param dateCode 日期编号
	 * @return 日期字符串
	 */
	public static String getYearDesc(String dateCode) {
		return getDateCodeToDesc(dateCode, "yyyy年", true);
	}
	
	
	/**
	 * 获取指定月份的起始时间和结束时间
	 * @param 指定的时间字符串
	 */
	public static String[] getMonthBenginTimeAndEndTime(String queryTime){
		String [] time  = new String [2];
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTimeInMillis(sdf.parse(queryTime).getTime());
		} catch (ParseException e) {
		}
		
		String benginTime = queryTime + "-";
		
		int bTime = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
		if(bTime < 10){
			benginTime += "0"+bTime;
		}
		else{
			benginTime += ""+bTime;
		}
		
		String endTime = queryTime + "-" + calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		time[0] = benginTime;
		time[1] = endTime;
		
		return time;
	}
	
	/**
	 * 获取指定年月的具体那周的起始时间和结束时间
	 * @param 指定的时间字符串  格式为:yyyy-MM
	 * @param 周的索引
	 */
	public static String[] getWeekBenginTimeAndEndTime(String queryTime,Integer weekIndex){
		String [] time  = new String [2];
		
		SimpleDateFormat weekFormat = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance(Locale.CHINA);
		try {
			calendar.setTimeInMillis(weekFormat.parse(queryTime).getTime());
		} catch (ParseException e) {
		}
		calendar.set(Calendar.DAY_OF_MONTH,1);
		
		//获取查询月的第一个星期一的时间
		if(calendar.get(Calendar.DAY_OF_WEEK) == 1){
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}
		else if(calendar.get(Calendar.DAY_OF_WEEK) != 2){
			int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
			calendar.add(Calendar.DAY_OF_MONTH, 9-dayOfWeek);
		}
		
		//根据查询的周数进行日期的7的倍数的回滚以至于得到查询周数的起始时间
		calendar.add(Calendar.DAY_OF_MONTH, (weekIndex-1)*7);
		String beginTime = dayFormat.format(calendar.getTime());
		
		//查询周数的结束时间
		calendar.add(Calendar.DAY_OF_MONTH, 6);
		String endTime = dayFormat.format(calendar.getTime());

		time[0] = beginTime;
		time[1] = endTime;
		
		return time;
	}
	
	/**
	 * 根据指定的时间获取当前月份有多少周
	 * @param 指定的时间字符串 格式:yyyy-MM
	 */
	public static int getWeekCount(String queryTime){
		SimpleDateFormat weekFormat = new SimpleDateFormat("yyyy-MM");
		Calendar calendar = Calendar.getInstance(Locale.CHINA);
		try {
			calendar.setTimeInMillis(weekFormat.parse(queryTime).getTime());
		} catch (ParseException e) {
		}
		calendar.set(Calendar.DAY_OF_MONTH,1);
		int dayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		int dayOfWeek = 0;
		//获取当前月份的第一天是星期几
		if(2 != calendar.get(Calendar.DAY_OF_WEEK)){
			dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)== 1 ? 1 : calendar.get(Calendar.DAY_OF_WEEK) -1;
		}
		dayOfMonth = dayOfMonth - dayOfWeek;
		//获取当前月的最后一天的日期
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		if(1 != calendar.get(Calendar.WEEK_OF_YEAR)){
			dayOfWeek = 8-calendar.get(Calendar.DAY_OF_WEEK);
		}
		dayOfMonth = dayOfMonth + dayOfWeek;
		
		return dayOfMonth/7;
	}
	
	/**
	 * 获取当前的时间的周的开始时间和结束时间，以及月份的默认时间
	 * @return 时间的数组：第一个默认年月、第二个当前周数、第三个周的开始时间、第四个周的结束时间
	 */
	public static Object[] getBeginTimeAndEndTimeAndDeFaultTime(){
		Object[] time = new Object[4];
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 31);
		
		//获取当前时间在本月处于第几周
		int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
		SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM");
		String queryTimes[] = null;
		String queryTime = null;
		if(weekOfMonth == 1){
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)-1;
			if(dayOfWeek != 1){
				//获取上个月的周数
				calendar.add(Calendar.DAY_OF_MONTH, -1);
				queryTime = monthFormat.format(calendar.getTime());
				weekOfMonth = getWeekCount(queryTime);
				queryTimes = getWeekBenginTimeAndEndTime(queryTime,weekOfMonth);
			}
			else{
				queryTime = monthFormat.format(calendar.getTime());
				queryTimes = getWeekBenginTimeAndEndTime(queryTime,1);
			}
		}
		else{
			queryTime = monthFormat.format(calendar.getTime());
			queryTimes = getWeekBenginTimeAndEndTime(queryTime,weekOfMonth);
			
		}
		time[0] = queryTime;
		time[1] = weekOfMonth;
		time[2] = queryTimes[0];
		time[3] = queryTimes[1];
		return time;
	}
	
	/**
	 * 获取当前的时间所在周的开始时间和结束时间
	 * @param  查询的时间 格式为 yyyy-MM-dd,如果为null，那查询的就是当前时间，否则就是查询的时间
	 * @return String类型的周的开始时间和结束时间格式为yyyy-MM-dd
	 */
	public static String[] getCurrWeekBeginTimeAndEndTimeForString(String queryTime){
		//声明一个接收周的开始时间和结束时间的数组
		String [] queryWeekBeginTimeAndEndTime = new String [2];
		
		//获取当前时间
		Calendar calendar = Calendar.getInstance();
		
		//格式化时间对象
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		//设置查询时间
		if(queryTime != null && !"".equals(queryTime)){
			try {
				calendar.setTimeInMillis(dayFormat.parse(queryTime).getTime());
			} catch (ParseException e) {
			}
		}
		
		//获取当前时间的星期
		int weekIndex = calendar.get(Calendar.DAY_OF_WEEK) != 1 ? calendar.get(Calendar.DAY_OF_WEEK)-1 : 7;
		
		//获取周的结束时间的相差天数
		int weekEndIndex = 7 - weekIndex;
		
		//获取周的开始时间的相差天数
		int weekBeginIndex = 1-weekIndex;
		
		//声明结束时间的对象
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTimeInMillis(calendar.getTimeInMillis());

		endCalendar.add(Calendar.DAY_OF_MONTH, weekEndIndex);
		queryWeekBeginTimeAndEndTime[1] = dayFormat.format(endCalendar.getTime());
		
		//声明开始时间的对象
		Calendar beginCalndar = Calendar.getInstance();
		beginCalndar.setTimeInMillis(calendar.getTimeInMillis());
		
		beginCalndar.add(Calendar.DAY_OF_MONTH, weekBeginIndex);
		queryWeekBeginTimeAndEndTime[0] = dayFormat.format(beginCalndar.getTime());
		
		return queryWeekBeginTimeAndEndTime;
	}
	
	/**
	 * 获取当前的时间所在周的开始时间和结束时间
	 * @param  查询的时间 格式为 yyyy-MM-dd,如果为null，那查询的就是当前时间，否则就是查询的时间
	 * @return Date类型的周的开始时间和结束时间
	 */
	public static Date[] getCurrWeekBeginTimeAndEndTimeForDate(String queryTime){
		Date[] queryWeekBeginTimeAndEndTime = new Date[2];
		
		Calendar beginTime = Calendar.getInstance();
		Calendar endTime = Calendar.getInstance();
		
		String [] queryWeekBeginTimeAndEndTimeOfString = getCurrWeekBeginTimeAndEndTimeForString(queryTime);
		
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			beginTime.setTimeInMillis(dayFormat.parse(queryWeekBeginTimeAndEndTimeOfString[0]).getTime());
			endTime.setTimeInMillis(dayFormat.parse(queryWeekBeginTimeAndEndTimeOfString[1]).getTime());
		} catch (ParseException e) {
		}
		
		queryWeekBeginTimeAndEndTime[0] = beginTime.getTime();
		queryWeekBeginTimeAndEndTime[1] = endTime.getTime();
		
		return queryWeekBeginTimeAndEndTime;
	}  
	
	/**
	 * 获取指定月份的所在季度的开始时间和结束时间
	 * @param 查询的月份格式为yyyy-MM;如果参数为null，则查询的是当前时间所在季度的开始时间和结束时间，否则就是查询的对应时间的开始时间和结束时间
	 * @return 查询出季度的开始时间和结束时间的数组
	 */
	public static String[] getQuerySeasionbyQueryTime(String queryTime){
		String [] beginTimeAndEndTime = new String [2]; 
		
		Calendar calendar = Calendar.getInstance();
		
		SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM");
		
		queryTime = queryTime != null && !"".equals(queryTime) ? queryTime : monthFormat.format(calendar.getTime());
		
		//获取月份
		String queryMonth = queryTime.split("-")[1];
		String queryYear = queryTime.split("-")[0];
		
		int month = Integer.parseInt(queryMonth);
		
		String beginTime = "";
		String endTime = "";
		
		if(0< month && month < 4){
			beginTime = queryYear + "-01-01";
			endTime = queryYear + "-03-31";
		}
		else if(3 < month && month < 7){
			beginTime = queryYear + "-04-01";
			endTime = queryYear + "-06-30";
		}
		else if( 6 < month && month < 10){
			beginTime = queryYear + "-07-01";
			endTime = queryYear + "-09-30";
		}
		else{
			beginTime = queryYear + "-10-01";
			endTime = queryYear + "-12-31";
		}
		
		beginTimeAndEndTime[0] = beginTime;
		beginTimeAndEndTime[1] = endTime;
		
		return beginTimeAndEndTime;
	}
	
	/**
	 * 根据时间段来算出该段时间内的总天数
	 * @param beginDate 格式为yyyyMMdd
	 * @param endDate 格式为yyyyMMdd
	 * @return
	 */
	public static List<String> getAllDayByBeginDataAndEndData(String beginDate,String endDate) throws Exception{
		List<String> dayList = new ArrayList<String>();
		Calendar beginCalendar = Calendar.getInstance();
		Calendar endCalendar = Calendar.getInstance();
		Calendar monthCalendar = Calendar.getInstance();
		SimpleDateFormat monthFormat = new SimpleDateFormat("yyyyMM");
		beginCalendar.setTimeInMillis(monthFormat.parse(beginDate).getTime());
		endCalendar.setTimeInMillis(monthFormat.parse(endDate).getTime());
		int beginYear = Integer.parseInt(beginDate.substring(0, 4));
		int endYear = Integer.parseInt(endDate.substring(0, 4));
		int beginMonth = Integer.parseInt(beginDate.substring(4, 6));
		int endMonth = Integer.parseInt(endDate.substring(4, 6));
		int beginDay = Integer.parseInt(beginDate.substring(6, 8));
		int endDay= Integer.parseInt(endDate.substring(6, 8));
		
		//同一年的处理
		if(beginYear == endYear){
			
			//同一月份的处理
			if(beginMonth == endMonth){
				for(int i = beginDay ; i <= endDay ; i++){
					dayList.add(beginYear+getTimeString(beginMonth)+getTimeString(i));
				}
			}
			//不同月份的处理
			else{
				//开始时间的处理
				int maxBeginDay = beginCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
				for(int i = beginDay ; i <= maxBeginDay ; i++){
					dayList.add(beginYear+getTimeString(beginMonth)+getTimeString(i));
				}
				
				//相差月份的处理
				for(int k = 1 ; k < (endMonth - beginMonth); k++){
					String queryMonth = beginYear + getTimeString(beginMonth+k);
					monthCalendar.setTimeInMillis(monthFormat.parse(queryMonth).getTime());
					int maxEndDay = monthCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
					for(int m = 1 ; m <= maxEndDay ; m++){
						dayList.add(queryMonth+getTimeString(m));
					}
				}
				
				//结束时间的处理
				for(int j = 1 ; j <= endDay; j++){
					dayList.add(beginYear+getTimeString(endMonth)+getTimeString(j));
				} 
				
			}
		}
		//不同年的处理
		else{
			//开始时间的处理
			//当前月份的处理
			monthCalendar.setTimeInMillis(monthFormat.parse(beginYear+getTimeString(beginMonth)).getTime());
			int maxday = monthCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			for(int i = beginDay ; i <= maxday; i++){
				dayList.add(beginYear+getTimeString(beginMonth)+getTimeString(i));
			}
			//本年其他月份的处理
			for(int i = beginMonth +1 ; i <= 12 ; i++){
				monthCalendar.setTimeInMillis(monthFormat.parse(beginYear+getTimeString(i)).getTime());
				maxday = monthCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
				for(int j = 1 ; j <= maxday ; j++){
					dayList.add(beginYear+getTimeString(i)+getTimeString(j));
				}
			}
			
			//相差年的处理
			for(int i = 1; i < endYear-beginYear; i++){
				for(int j = 1 ; j <= 12 ;j++){
					monthCalendar.setTimeInMillis(monthFormat.parse((beginYear+i)+getTimeString(j)).getTime());
					maxday = monthCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
					for(int k = 1 ; k <= maxday ; k++){
						dayList.add((beginYear+i)+getTimeString(j)+getTimeString(k));
					}
				}
			}
			
			//本年其他月份的处理
			for(int i = 1 ; i <= endMonth -1 ;i++){
				monthCalendar.setTimeInMillis(monthFormat.parse(beginYear+getTimeString(i)).getTime());
				maxday = monthCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
				for(int j = 1 ; j <= maxday ; j++){
					dayList.add(endYear+getTimeString(i)+getTimeString(j));
				}
			}
			
			//结束时间的处理
			//结束月的处理
			for(int i = 1 ; i <= endDay ; i++){
				dayList.add(endYear+getTimeString(endMonth)+getTimeString(i));
			}
		}
		
		return dayList;
	}
	
	/**
	 * 将小于10的数字转成带0的字符串
	 * @param time int类型
	 * @return 两位的数字字符串
	 */
	public static String getTimeString(int time){
		String timeDay = ""+time;
		if(time < 10){
			timeDay = "0"+time;
		}
		return timeDay;
	}
}
