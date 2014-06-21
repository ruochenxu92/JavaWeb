package us.junitTest;

import java.util.Date;

import org.junit.Test;

import us.BusinessServiceImpl.BusinessServiceImpl;
import us.domain.User;
import us.exception.UserExistException;

public class registerTest {
	
	@Test
	public void register(){
		User user = new User();
		user.setBirthday(new Date());
		user.setEmail("xxx@gmail.com");
		user.setNickname("sss");
		user.setPassword("sss");
		user.setUsername("Ichangehere");
		
		
		BusinessServiceImpl service = new BusinessServiceImpl();
		try {
			service.register(user);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	

}
