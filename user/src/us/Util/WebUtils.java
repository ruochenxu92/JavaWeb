package us.Util;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import us.domain.User;
import us.web.formbean.RegisterForm;

public class WebUtils {

	public static <T> T request2Bean(HttpServletRequest request,
			Class<T> beanClass) {
		T bean;
		try {
			bean = beanClass.newInstance();

			Enumeration e = request.getParameterNames();
			while (e.hasMoreElements()) {
				String name = (String) e.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
			}
			return bean;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public static void copyBean(Object src, Object dest) {
		ConvertUtils.register(new Converter() {
			
			@Override
			public Object convert(Class type, Object value) {
				if(value == null){
					return null;
				}
				String str = (String) value;
				if(str.trim().equals(""))
					return null;
				
				SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
				 Date date;
				try {
					date = df.parse(str);
					return date;
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
			}
		}, Date.class);
		
		try {
			BeanUtils.copyProperties(dest, src);
		} catch (Exception e){
			throw new RuntimeException(e);
		}
		
	}
	
	public static String generateID(){
		return UUID.randomUUID().toString();
	}
	
	
	
	
	
	

}
