package junit.test;

import java.util.Date;

import org.junit.Test;

import facebook.dao.UserDao;
import facebook.dao.imple.UserDaoImpl;
import facebook.domain.User;


public class UserDaoTest {
	@Test
	public void testAdd(){
		User user = new User();
		user.setBirthday(new Date());
		user.setEmail("thomasxu@gmail.com");
		user.setId("xxu46");
		user.setNickname("Jiahui Xu");
		user.setUsername("Jay");
		user.setPassword("Jiahu");
		
		UserDao dao = new UserDaoImpl();
		dao.add(user);
	}
	
	
	@Test
	public void testFind(){
		UserDao dao = new UserDaoImpl();
		dao.find("aaa", "123");
	}
	
	@Test
	public void testFindByUsername(){
		UserDao dao = new UserDaoImpl();
		System.out.println(dao.find("aaa"));
	}
	
	
	
	
	
}
