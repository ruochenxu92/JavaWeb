package demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

public class Demo3 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Savepoint sp = null;
		
		try{
			conn = utils.JdbcUtils.getConnection();
			conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
			conn.setAutoCommit(false);
			
			String sql = "select * from account where name='aaa'";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			rs.next();
			System.out.println(rs.getFloat("money"));
			
			Thread.sleep(1000*10);
			rs = st.executeQuery();
			rs.next();
			System.out.println(rs.getFloat("money"));	
			
			Thread.sleep(1000*10);
			rs = st.executeQuery();
			rs.next();
			System.out.println(rs.getFloat("money"));	
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			utils.JdbcUtils.release(conn, st, rs);
		}
	}
}
