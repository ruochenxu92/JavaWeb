package demo;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	private static ComboPooledDataSource ds = null;
	static{
		try{
			ds = new ComboPooledDataSource();
		}catch(Exception e){
			throw new  ExceptionInInitializerError(e);
		}
	}
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	public static DataSource getDataSource() {
		return ds;
	}
	
	
	
}