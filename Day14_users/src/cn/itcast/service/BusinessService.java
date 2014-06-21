package cn.itcast.service;

import cn.itcast.domain.User;
import cn.itcast.exception.UserExistException;

public interface BusinessService {

	//�ṩע�����
	void registerUser(User user) throws UserExistException;

	User loginUser(String username, String password);

}