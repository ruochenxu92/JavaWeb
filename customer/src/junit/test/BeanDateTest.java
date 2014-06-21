package junit.test;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Enumeration;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

import domain.Customer;

public class BeanDateTest {

//	@Test
//	public void demo() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
//		Customer c = new Customer();
//		
//		ConvertUtils.register(new Converter(), Date.class);
//		BeanUtils.setProperty(c, "id", "1");
//		System.out.println(BeanUtils.getProperty(c, "birthday"));
//	}
}
