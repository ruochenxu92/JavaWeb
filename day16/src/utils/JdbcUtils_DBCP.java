package utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class JdbcUtils_DBCP {
	private static DataSource ds = null;
	static{
		try {
			InputStream in = JdbcUtils_DBCP.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			Properties prop = new Properties();
			prop.load(in);//prop has already load inputstream
			
			//2. create a factory, and use factory to create datasource
			BasicDataSourceFactory factory = new BasicDataSourceFactory();
			ds = factory.createDataSource(prop);
		}catch(Exception e){
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static Connection getConnection() throws Exception{
		return ds.getConnection();
	}
	
	

	public static void release(Connection conn, PreparedStatement st, ResultSet rs){
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e1) {

			}
			rs = null;
		}
		if (st != null) {
			try {
				st.close();
			} catch (Exception e2) {

			}
			st = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e3) {

			}
			conn = null;
		}
	}
}
