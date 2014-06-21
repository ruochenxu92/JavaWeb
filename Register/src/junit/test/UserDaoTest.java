package junit.test;

import java.util.Date;

import org.junit.Test;

import us.dao.UserDao;
import us.dao.impl.UserDaoImpl;
import us.domain.User;

public class UserDaoTest {

	@Test
	public void testAdd(){
		User user = new User();
		user.setBirthday(new Date());
		user.setEmail("xxx@gmail.com");
		user.setId("02");
		user.setNickname("selang");
		user.setPassword("123");
		user.setUsername("xxx");
		
		UserDao dao = new UserDaoImpl();
		dao.add(user);
		
	}
	
	@Test
	public void testFind(){
		UserDao dao = new UserDaoImpl();
		dao.find("aaa", "123");
	}
	
	@Test
	public void testFind2(){
		UserDao dao = new UserDaoImpl();
		boolean b = dao.find("aaa");
		System.out.println(b);
	}
	

}
