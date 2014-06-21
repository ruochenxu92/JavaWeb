package junit.test;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

public class test {
//	
//	  @Test
//	  public void testDate() throws ParseException {
//	        DateType dt = new DateType();
//
//	        dt.setDate("25-dec-05");
//	        
//	        Date date = (Date) IntrospectionHelper.valueFor(dt, Date.class);
//	        assertEquals("date", new SimpleDateFormat("dd-MMM-yy").parse("25-DEC-05"), date);
//	        assertEquals("date", new SimpleDateFormat("dd-MMM-yy").parse("25-DEC-05").toString(), date.toString());
//	   }
	
	  @Test
	  public void testDate2() throws Exception {
		  
		  dog d = new dog();
			BeanUtils.setProperty(d,"name", "kitty");
			BeanUtils.setProperty(d,"birthday", "01/01/2011");

			  System.out.println(BeanUtils.getProperty(d,"name"));
			  System.out.println(BeanUtils.getProperty(d,"date"));
			  
		  DateLocaleConverter converter = new DateLocaleConverter(, "dd-MM-yyyy");
		  System.out.println( converter.convert("25-12-2005"));
		  
		  
		  converter.setLenient(true);
          ConvertUtils.register(converter, Date.class);
          
   
          BeanUtils.setProperty(d,"name", "kitty");
      	  BeanUtils.setProperty(d,"birthday", "25-12-2005");

		  System.out.println(BeanUtils.getProperty(d,"name"));
		  System.out.println(BeanUtils.getProperty(d,"date"));
		
      }
	
	
	
	
	
	
	
	
	@Test
	public void test() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{	
//		SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		//String date = "1991-01-11";
		//String date = "01-01-1919";
//		String formattedDate = df.format(date);
		DateTimeConverter dtConverter = new DateConverter();
		dtConverter.setPattern("dd/MMM/yyyy");
		ConvertUtils.register(dtConverter, Date.class);
		dog d = new dog();
		BeanUtils.setProperty(d,"name", "kitty");
		BeanUtils.setProperty(d,"birthday", "01/01/2011");

		  System.out.println(BeanUtils.getProperty(d,"name"));
		  System.out.println(BeanUtils.getProperty(d,"date"));
	
	}
	
	@Test 
	public void test3(){
		 Date date = new Date();
	        
	       // display time and date using toString()
	      System.out.println(date.toString());
	}
	
	public static void main(String args[]) {
	      SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 

	      String input = args.length == 0 ? "1818-11-11" : args[0]; 

	      System.out.print(input + " Parses as "); 

	      Date t; 
	      try { 
	          t = ft.parse(input); 
	          System.out.println(t); 
	      } catch (ParseException e) { 
	          System.out.println("Unparseable using " + ft); 
	      }
	   }
	
	
	
	@Test
	 public void test2() throws Exception {
	  ConvertUtils.register(new DateLocaleConverter(), Date.class);//可自己实现Converter接口 日期转换
	  dog d = null;
	  BeanUtils.setProperty(d,"name", "kitty");
	  BeanUtils.setProperty(d,"birthday", "2011-01-01");
	  System.out.println(BeanUtils.getProperty(d,"name"));
	  System.out.println(BeanUtils.getProperty(d,"birthday"));
	 }
	
	
	
	
	
	
}
