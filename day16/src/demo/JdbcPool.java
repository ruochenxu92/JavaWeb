package demo;

import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class JdbcPool implements DataSource {
	private static LinkedList<Connection> list = new LinkedList<Connection>();
	static{
		//get a large num of connections
		
		try{
			// 1.prepare to read the properties documents
			InputStream in = JdbcPool.class.getClassLoader()
					.getResourceAsStream("db.properties");
			Properties prop = new Properties();
			prop.load(in);
			// 2.start read properties documents
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");

			Class.forName(driver);
			// 3.use properties info to connect database and get a amount of connections to build connection pool
			for (int i = 0; i < 10; i++) {
				Connection conn = DriverManager.getConnection(url, username,
						password);
				list.add(conn);
			}
		}catch(Exception e){
			throw new ExceptionInInitializerError(e);
		}	
	}
	@Override
	public Connection getConnection() throws SQLException {
		//override getConnection method such that people will return the connection directly to connection pool rather than database
		if (list.size() > 0) {
			final Connection conn = list.removeFirst();// conn.close()
			System.out.println("pool size is: " + list.size());

			return (Connection) Proxy.newProxyInstance(JdbcPool.class.getClassLoader(), conn.getClass().getInterfaces(),
					new InvocationHandler() {
						@Override
						public Object invoke(Object proxy, Method method,
								Object[] args) throws Throwable {

							if (!method.getName().equals("close")) {
								return method.invoke(conn, args);
							} else {
								System.out.println("connection is given back!");
								list.add(conn);
								System.out.println("pool size is: " + list.size());
								return null;
							}
						}
					});
		} else {
			throw new RuntimeException("Sorry, data is business");
		}
	}
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Connection getConnection(String username, String password)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	

}





/*
 * 
 * Use wrapper model strengthen a method
 * 1.write a class implements interface of the object should be strengthen
 *
 * 2. define a variable, point to the object
 * 
 * 3. define a constructor, accept the object
 * 
 * 4. cover the method that should be strengthen
 * 
 * 5. directly use method that not be strengthen
 * 
 * 
 */



