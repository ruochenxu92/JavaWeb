package us.BusinessServiceImpl;

import org.junit.Test;

import us.UserDao.UserDao;
import us.UserDaoImpl.UserDaoImpl;
import us.Util.ServiceUtil;
import us.Util.WebUtils;
import us.domain.User;
import us.exception.UserExistException;

public class BusinessServiceImpl {
	
	
	
	private UserDao dao = new UserDaoImpl();
	
	public void register(User user) throws UserExistException{
		boolean b = dao.find(user.getUsername());
		if(b){
			throw new UserExistException();
		}else{
			user.setPassword(ServiceUtil.md5(user.getPassword()));
			user.setId(WebUtils.generateID());
			dao.add(user);
		}		
	}
	
	@Test
	public void login(){
		String username="rrrrrr";
		String password="123";
		
		BusinessServiceImpl service = new BusinessServiceImpl();
		
		User user = service.login(username, password);
	
	}
	
	
	
	
	public User login(String username, String password){
		password = ServiceUtil.md5(password);
		System.out.println(password);
		User user =  dao.find(username,password);
		if(user != null){
			System.out.println("successfully");
		}else{
			System.out.println("fail");
		}
		return user;
	
	}
	
	
	
	
	
	
}
