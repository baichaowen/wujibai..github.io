package cn.bdqn.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;
import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

public class DateConverter extends StrutsTypeConverter{
	
	private static final DateFormat[] dfs = {
			new SimpleDateFormat("yyyy 年MM 月dd 日"),
			new SimpleDateFormat("yyyy-MM-dd"),
			new SimpleDateFormat("MM/dd/yy"),
			new SimpleDateFormat("yyyy.MM.dd"),
			new SimpleDateFormat("yyyyMMdd"),
			new SimpleDateFormat("yyyy/MM/dd"),
	};
	
	public Object convertFromString(Map context,String[] values,Class toType){
			String dateStr=values[0];
			for(int i=0;i<dfs.length;i++){
				try {
					return dfs[i].parse(dateStr);
				} catch (Exception e) {
					continue;
				}
				
			}
			throw new TypeConversionException("转换错误");
	}
	public String convertToString(Map context,Object object){
		Date date=(Date) object;
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
		
	}
}
