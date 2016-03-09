package com.qzw.contrllor.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.converter </p>
 * <p> 类名称：DateConverter.java  </p>
 * <p> 类描述：自定义的SpringMVC转换器：用于把转换日期类型 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2015年11月14日  下午6:10:56
 * @version 1.0
 */
public class DateConverter implements Converter<String, Date> {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Date convert(String source) {
		if (source == null || source.trim().equals("")) {
			return null;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			logger.error("Date参数类型转换异常", e);
		}
		return null;
	}
}