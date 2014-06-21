package us.junitTest;

import org.junit.Test;

import us.BusinessServiceImpl.BusinessServiceImpl;
import us.domain.User;

public class loginTest {

	@Test
	public void login(){
		String username="rrrrrr";
		String password="123";
		
		BusinessServiceImpl service = new BusinessServiceImpl();
		
		User user = service.login(username, password);
		System.out.println(user);
	}
}
