package utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	private static ComboPooledDataSource ds = null;
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal();
	
	static{
		ds = new ComboPooledDataSource("flx");
	}
	
	public static Connection getConnection() throws SQLException{
		Connection conn = threadLocal.get();
		if(conn==null){
			conn = getDataSource().getConnection();
			threadLocal.set(conn);
		}
		return conn;
	}
    
    
    public static DataSource getDataSource(){
        return ds;
    }

    public static void startTransaction(){
        try{
            Connection conn = threadLocal.get();
            if(conn == null){
                conn = getConnection();
                threadLocal.set(conn);
            }
            conn.setAutoCommit(false);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

	
	public static void rollback(){
		try{
			Connection conn =  threadLocal.get();
			if(conn!=null){
				conn.rollback();
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
    

	
	public static void commit(){
		try{
			Connection conn =  threadLocal.get();
			if(conn!=null){
				conn.commit();
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void release(){
		try{
			Connection conn =  threadLocal.get();
			if(conn!=null){
				conn.close();
				threadLocal.remove(); //Ω‚≥˝µ±«∞œﬂ≥Ã…œ∞Û∂®conn
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
    
}

