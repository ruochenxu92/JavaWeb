package utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class WebUtils {
	
	public static <T> T request2Bean(HttpServletRequest request,Class<T> clazz){
		
		try{
			T t = clazz.newInstance();
//			ConvertUtils.register(new DateLocaleConverter(), Date.class);
//			ConvertUtils.register(new Converter(){
//				@Override
//				public Object convert(Class type, Object value) {
//					if(value == null){
//						return null;
//					}
//					if(!(value instanceof String)){
//						return null;
//					}
//					String date = (String) value;
//					if(date.trim().equals("")){
//						return null;
//					}
//					System.out.println(date);
//					SimpleDateFormat  df =   new SimpleDateFormat("yyyy-MM-dd");
//					try{
//						return df.parse(date);
//					}catch(ParseException e){
//						throw new RuntimeException(e);
//					}
//				}
//			},Date.class);
			
			Enumeration e = request.getParameterNames();
			while(e.hasMoreElements()){
				String name = (String) e.nextElement();
				String value = request.getParameter(name);
				
				BeanUtils.setProperty(t, name, value);
			}
			return t;
			
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	public static String makeId(){
		return UUID.randomUUID().toString();	
	}
}




