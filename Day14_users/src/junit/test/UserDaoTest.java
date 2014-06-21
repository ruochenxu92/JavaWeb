package junit.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoXmlImpl;
import cn.itcast.domain.User;

public class UserDaoTest {
	
	@Test
	public void testAdd(){
		User user = new User();
		user.setId("4");
		user.setUsername("Bobby");
		user.setPassword("123");
		user.setEmail("Bobby@gmail.com");
		
	
		UserDao dao = new UserDaoXmlImpl();
		dao.add(user);
	}
	
	@Test
	public void testFind(){
		
		UserDao dao = new UserDaoXmlImpl();
		User user = dao.find("Cinda","123");
		System.out.println(user);
	}
	
	@Test
	public void testFindByUsername(){
		UserDao dao = new UserDaoXmlImpl();
		User user = dao.find("Cinda");
		System.out.println(user);
	}
	
}
