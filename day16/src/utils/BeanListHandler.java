package utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BeanListHandler implements ResultSetHandler{
	private Class clazz;
	public BeanListHandler(Class clazz){
		this.clazz = clazz;
	}
	@Override
	public Object handle(ResultSet rs) {
		try {	
			if(rs == null){
				return null;
			}
			List list = new ArrayList();
			ResultSetMetaData metadata = rs.getMetaData();
			int columncount = metadata.getColumnCount();
			while(rs.next()){
				Object bean = clazz.newInstance();
				for(int i=0; i < columncount; i++){
					
					Object columndata = rs.getObject(i+1);
					String columnName = metadata.getColumnName(i+1);
					Field field = clazz.getDeclaredField(columnName);
					field.setAccessible(true);
					field.set(bean, columndata);
					
				}
				list.add(bean);
			}
			return list.size()>0?list:null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
