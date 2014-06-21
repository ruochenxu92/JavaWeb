package facebook.service.impl;

import facebook.dao.UserDao;
import facebook.dao.imple.UserDaoImpl;
import facebook.domain.User;
import facebook.exception.UserExistException;
import facebook.utils.ServiceUtils;


//provide web layout business
public class BusinessServiceImpl {
	private UserDao dao = new UserDaoImpl();     //Factory, String
	
	
	//provide register service
	public void register(User user){
		//judge whether user exist or not
		boolean b = dao.find(user.getUsername());
		if(b){
			//throw new UserExistException();//register username 
		}else{
			user.setPassword(ServiceUtils.md5(user.getPassword()));
			dao.add(user);
		}
	}
	
	public User login(String username, String password){
		password = ServiceUtils.md5(password);
		return dao.find(username, password);
	}
	
	
	
	
}
