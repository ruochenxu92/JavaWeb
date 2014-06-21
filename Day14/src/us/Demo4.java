package us;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import us.Utils.JdbcUtils;



//use jdbc to CURD database
public class Demo4 {
	@Test
	public void insert() throws SQLException{
		Connection conn = JdbcUtils.getConnection();
		Statement st = conn.createStatement();
		String sql="insert into users(name,password,email,birthday) values('Jay','123','Jay@gmail.com','1993-02-02')";
		int num = st.executeUpdate(sql);
		if(num > 0){
			System.out.println("Succesfully insert");
		}
		ResultSet rs = null;
		JdbcUtils.release(conn, st, rs);
	}
	
	@Test
	public void delete() throws SQLException{
		Connection conn = JdbcUtils.getConnection();
		Statement st= conn.createStatement();
		String sql="delete from users where name = 'Jay'";
		int num = st.executeUpdate(sql);
		if(num > 0){
			System.out.println("Successfully Delete");
		}else{
			System.out.println("Database is not affected");
		}
		ResultSet rs = null;
		JdbcUtils.release(conn, st, rs);
	}
	
	@Test
	public void update() throws SQLException{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		
		
		
		try{
			 conn = JdbcUtils.getConnection();
			 st = conn.createStatement();
			String sql = "Update users set name='Bill' where name='Thomas'";
			int num = st.executeUpdate(sql);
			if(num > 0){
				System.out.println("Successfully Update");
			}else{
				System.out.println("Database is not affected");
			}
			 rs = null;
			
		}catch(Exception e){
			
		}finally{
			JdbcUtils.release(conn, st, rs);

		}
		
	}
	
	@Test
	public void find() throws SQLException{
		Connection conn = JdbcUtils.getConnection();
		Statement st = conn.createStatement();
		
		String sql = "select name, password, email, birthday from users where name like 'Th%'";
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
			System.out.println("name="+rs.getString("name"));
			System.out.println("password="+rs.getString("password"));
			System.out.println("email="+rs.getString("email"));
			System.out.println("birthday="+rs.getDate("birthday"));
		}
		JdbcUtils.release(conn, st, rs);
	}
	
	
}
