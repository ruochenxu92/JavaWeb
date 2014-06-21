package cn.itcast.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import cn.itcast.dao.UserDao;

public class DaoFactory {
	private UserDao userdao = null;
	private DaoFactory(){
		//1 read the properties file
		try {
			InputStream in = DaoFactory.class.getClassLoader()
					.getResourceAsStream("dao.properties");
			Properties prop = new Properties();
			prop.load(in);	
			//2 get className
			String DaoClassName = prop.getProperty("userdao");
			userdao = (UserDao) Class.forName(DaoClassName).newInstance();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	};
	private static final DaoFactory instance = new DaoFactory();
	
	private DaoFactory createInstance(){
		return instance;
	}
	
	
	
	
	private UserDao createUserDao(){
		
		return userdao;
	}
	
	
}



