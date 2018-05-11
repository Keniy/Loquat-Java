package com.loquat.user.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

/**
 * 日期格式转换器
 * @author liugy
 *
 */
public class DateConverter implements Converter<String, Date>{
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public Date convert(String s) {
		if (StringUtils.isBlank(s)) {
			return null;
		}
		try {
			return dateFormat.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
