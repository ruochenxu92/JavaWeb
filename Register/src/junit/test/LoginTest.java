package junit.test;

import org.junit.Test;

import us.dao.UserDao;
import us.dao.impl.UserDaoImpl;

public class LoginTest {

	@Test
	public void logintest0(){
		String username = "aaa";
		String password ="123";
		
		UserDao dao = new UserDaoImpl();
		dao.find(username, password);
		
	}

}
