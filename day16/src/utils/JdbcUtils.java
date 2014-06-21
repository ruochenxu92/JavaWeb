package utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
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
	
	
	
	public static void update(String sql, Object[] params) throws Exception{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try{
			conn =JdbcUtils_c3p0.getConnection();
			st = conn.prepareStatement(sql);
			for(int i = 0; i < params.length; i++){
				st.setObject(i+1, params[i]);
			}
			st.executeUpdate();
		}finally{
			JdbcUtils_c3p0.release(conn, st, rs);
		}
		
	}
	
	public static Object query(String sql, Object[] params, ResultSetHandler rsh) throws Exception{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try{
			conn = JdbcUtils_c3p0.getConnection();
			st = conn.prepareStatement(sql);
			for(int i= 0; i< params.length;i++){
//				System.out.println("?=" +params[i]);
				st.setObject(i+1, params[i]);
			}
			rs = st.executeQuery();
			return rsh.handle(rs);
		}finally{
			JdbcUtils_c3p0.release(conn, st, rs);
		}
	}
	
	
}
