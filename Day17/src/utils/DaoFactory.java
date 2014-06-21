package utils;

import dao.DepartmentDao;

public class DaoFactory {
	private DaoFactory(){}
	private static final DaoFactory instance = new DaoFactory();
	// create a factory
	public static DaoFactory getInstance(){
		return instance;
	}
	
	
	
	//method for create Dao
	
	public static  <T> T createDao(String classname, Class<T> clazz){
		
		try {
			return (T) Class.forName(classname).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		
	}
	
	
	
	
	
	
	
	
}
