package webservlet;

import java.util.List;

import domain.User;

public class UserDao {
	
	public User find(String username, String password){
		List<User> list = DB.MyDb.getAll();
		
		for(User user : list){
			if(user.getUsername().equals(username) && user.getPassword().equals(password)){
				return user;
			}
		}
		return null;
	}
	
	public User find(String username){
		List<User> list = DB.MyDb.getAll();
		for(User user : list){
			if(user.getUsername().equals(username)){
				return user;
			}
		}
		return null;
		
	}
	
	
	
	
}
