package junit.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import us.domain.User;
import us.exception.UserExistException;
import us.service.impl.BusinessServiceImpl;

public class ServiceTest {

	@Test
	public void testRegister() throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		String formattedDate = "2011-11-11";
		Date dateWithTime = df.parse(formattedDate);
		User user = new User();
		user.setBirthday(dateWithTime);
		user.setEmail("fff@gmail.com");
		user.setId("07");
		user.setNickname("haha");
		user.setPassword("123");
		user.setUsername("rrr");
		
		BusinessServiceImpl service = new BusinessServiceImpl();
		
		try {
			service.register(user);
			System.out.println("Success Register");
		} catch (UserExistException e) {
			System.out.println("User Exists");
		}
		
	}
	
	@Test
	public void testLogin(){
		BusinessServiceImpl service = new BusinessServiceImpl();
		String username = "fff";
		String password = "123";
		User user = service.login(username, password);
		
	}

}
