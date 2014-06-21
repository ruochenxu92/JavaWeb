package junit.test;

import java.util.Date;

import facebook.domain.User;
import facebook.service.impl.BusinessServiceImpl;

public class ServiceTest {
	
	public void testRegister(){
		User user = new User();
		user.setBirthday(new Date());
		user.setEmail("thomasxu@gmail.com");
		user.setId("1222");
		user.setNickname("Jiahui Xu");
		user.setUsername("Ja");
		user.setPassword("Jiahu");
		
	}
	
	public void testLogin(){
		BusinessServiceImpl service = new BusinessServiceImpl();
		User user = service.login("ja","Jiahu");
				
	}
}
