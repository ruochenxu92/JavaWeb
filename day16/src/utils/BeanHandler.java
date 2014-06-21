package utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class BeanHandler implements ResultSetHandler{
	private Class clazz;
	public BeanHandler(Class clazz){
		this.clazz = clazz;
	}
	@Override
	public Object handle(ResultSet rs)  {
		try{
			if(!rs.next()){
				return null;
			}
			Object bean = clazz.newInstance();
			
			ResultSetMetaData metadata = rs.getMetaData();
			int columnCount = metadata.getColumnCount(); 
			for(int i=0;i<columnCount;i++){
				String coulmnName = metadata.getColumnName(i+1); 
				Object coulmnData = rs.getObject(i+1);
				
				Field f = clazz.getDeclaredField(coulmnName);
				f.setAccessible(true);
				f.set(bean, coulmnData);
			}
			return bean;
		
		
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	

}
