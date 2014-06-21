package junit.test;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

public class date
	        @Test
	        public void test1() throws Exception
	        {
	                person p=new person();
	                BeanUtils.setProperty(p, "age", "25");
	                System.out.println(p.getAge());
	        }
	        @Test
	        public void test2() throws Exception
	        {
	                String name="allal";
	                String age="24";
	                String birthday="1988-07-14";
	                
	                /*ConvertUtils.register(new Converter() {//[color=Red]用这个注册的时候，可以正确转换[/color]
	                        
	                        @Override
	                        public Object convert(Class type, Object value) {
	                                
	                                if(value==null)
	                                {
	                                        return null;
	                                }
	                                if(!(value instanceof String))
	                                {
	                                        return null;
	                                }
	                                String values=(String)value;
	                                if(values.trim()=="")
	                                {
	                                        return null;
	                                }
	                                
	                                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	                                try {
	                                        return sdf.parse(values);
	                                } catch (ParseException e) {
	                                        // TODO Auto-generated catch block
	                                        throw new RuntimeException(e);
	                                }
	                        }
	                }, Date.class);
	                */
	            ConvertUtils.register(new DateLocaleConverter(), Date.class);//用这个方法的时候就会出现这个错误：2012-6-9 22:28:17 org.apache.commons.beanutils.locale.converters.DateLocaleConverter getFormatter
	                person p=new person();
	                BeanUtils.setProperty(p, "name", name);
	                BeanUtils.setProperty(p, "age", age);
	                BeanUtils.setProperty(p, "birthday", birthday);
	                
	                System.out.println(p.getName());
	                System.out.println(p.getAge());
	                System.out.println(p.getBirthday());
	                
	        }
}
