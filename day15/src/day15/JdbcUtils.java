package day15;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;



public class JdbcUtils {
	public static String url = null;
	public static String username = null;
	public static String password = null;
	
	static{
		try{
		InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
		Properties prop = new Properties();
		prop.load(in);
		String driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		Class.forName(driver);
	
		}catch(Exception e){
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static Connection getConnection() throws SQLException{
		 return  DriverManager.getConnection(url,username,password);
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
