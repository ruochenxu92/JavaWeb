package day15;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;


public class Demo3 {
	
	
	@Test 
	public void testbatch2(){
		Connection conn =null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			
			String sql= "insert into testbatch(id,name) values(?,?)";
			st = conn.prepareStatement(sql);
			
			for(int i=0; i < 1000008; i++){
				st.setInt(1,i);
				st.setString(2,"A"+i);
				st.addBatch();
				
				if(i % 1000 == 0){
					st.executeBatch();
					st.clearBatch();
				}
				st.executeBatch();
			}
			
	
	}catch(Exception e){
			
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	
	
//	
//	@Test 
//	public void testbatch(){
//		Connection conn =null;
//		PreparedStatement st = null;
//		ResultSet rs = null;
//		try{
//			conn = JdbcUtils.getConnection();
//			
//			
//			String sql1 = "insert into testbatch(id,name) values(1,'AAA')";
//			String sql2 = "insert into testbatch(id,name) values(2,'BBB')";
//			String sql3 = "insert into testbatch(id,name) values(3,'CCC')";
//
//			st = conn.createStatement();
//			st.addBatch(sql1);
//			st.addBatch(sql2);
//			st.addBatch(sql3);
//			
//			st.executeBatch();
//			st.clearBatch();
//			
//		}catch(Exception e){
//			
//		}finally{
//			JdbcUtils.release(conn, st, rs);
//		}
//	}
//	
	
}
