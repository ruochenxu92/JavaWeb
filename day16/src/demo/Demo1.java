package demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.JdbcUtils_c3p0;



public class Demo1 {
	
	
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
//		Savepoint sp = null;
		
		try{
			conn = JdbcUtils_c3p0.getConnection();
			conn.setAutoCommit(false);//start transaction
			
			String sql1 = "update account set money= money-100 where name='aaa'";	
			st = conn.prepareStatement(sql1);
			st.executeUpdate();
			
//			sp = conn.setSavepoint();
			
			String sql2 = "update account set money= money+100 where name='bbb'";
			st = conn.prepareStatement(sql2);
			st.executeUpdate();
						
//			String sql3 = "update account set money= money+100 where name='ccc'";
//			st = conn.prepareStatement(sql3);
//			st.executeUpdate();
			
			conn.commit();
			
			System.out.println("Success!");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtils_c3p0.release(conn, st, rs);
		}
	}
	
	
	
}
