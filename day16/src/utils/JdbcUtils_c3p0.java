package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils_c3p0 {
	private static ComboPooledDataSource ds = null;
	static {
		try {
			ds = new ComboPooledDataSource();
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getConnection() throws Exception {
		return ds.getConnection();
	}

	public static void release(Connection conn, PreparedStatement st,
			ResultSet rs) {
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
