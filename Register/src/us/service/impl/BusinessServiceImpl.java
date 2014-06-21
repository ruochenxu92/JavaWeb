package us.service.impl;

import us.dao.UserDao;
import us.dao.impl.UserDaoImpl;
import us.domain.User;
import us.exception.UserExistException;
import us.utils.ServiceUtils;

public class BusinessServiceImpl {
	private UserDao dao = new UserDaoImpl();
	
	public void register(User user) throws UserExistException{
		boolean b = dao.find(user.getUsername());
		if(b){
			throw new UserExistException();
		}else{
			user.setPassword(ServiceUtils.md5(user.getPassword()));
			dao.add(user);
		}
	}
	
	
	public User login(String username, String password){
		//md5
		 password = ServiceUtils.md5(password);
		 System.out.println(password);
		 return dao.find(username, password);
	}
}
