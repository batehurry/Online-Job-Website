package com.qzw.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期工具类
 * 
 * @author 胜泽
 * 
 */
public class DateUtil {
	
	private DateUtil() {
		
	}
	
	/**
	 * Logger for this class
	 */
	private static final Logger log = LoggerFactory.getLogger(DateUtil.class);

	/**
	 * SimpleDateFormat函数语法：
	 * 
	 * G 年代标志符 y 年 M 月 d 日 h 时 在上午或下午 (1~12) H 时 在一天中 (0~23) m 分 s 秒 S 毫秒 E 星期 D
	 * 一年中的第几天 F 一月中第几个星期几 w 一年中第几个星期 W 一月中第几个星期 a 上午 / 下午 标记符 k 时 在一天中 (1~24) K
	 * 时 在上午或下午 (0~11) z 时区
	 */

	/**
	 * 日期转字符串
	 * 
	 * @param date
	 *            日期
	 * @param pattern
	 *            格式
	 * @return
	 */
	public final static String dateToString(Date date, String pattern) {
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			String returnString = sdf.format(date);
			return returnString;
		}
		return "";
	}

	/**
	 * 日期转12小时制字符串
	 * 
	 * @param date
	 * @return
	 */
	public final static String dateToString12(Date date) {
		String returnString = dateToString(date, "yyyy-MM-dd a hh:mm:ss");
		return returnString;
	}

	/**
	 * 日期转24小时制字符串
	 * 
	 * @param date
	 * @return
	 */
	public final static String dateToString24(Date date) {
		String returnString = dateToString(date, "yyyy-MM-dd HH:mm:ss");
		return returnString;
	}

	/**
	 * 将yyyy-MM-dd HH:mm:ss格式的字符串转换成Date对象
	 * 
	 * @param str
	 * @return
	 */
	public final static Date stringToDate24(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			log.error("字符串转换Date对象异常！", e);
		}
		return date;
	}

	/**
	 * 将yyyy-MM-dd a hh:mm:ss格式的字符串转换成Date对象
	 * 
	 * @param str
	 * @return
	 */
	public final static Date stringToDate12(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			log.error("字符串转换Date对象异常！", e);
		}
		return date;
	}
}