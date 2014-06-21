package dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import domain.Page;
import domain.Student;

public class StudentDao {
	public int getTotalRecords(){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = utils.JdbcUtils.getConnection();
			String sql = "select count(*) from student";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			rs.next();
			return rs.getInt(1);
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			utils.JdbcUtils.release(conn, st, rs);
		}
		
	}


	

	public ArrayList<Student> getPageData(int startIndex, int pagesize){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try{
			conn = utils.JdbcUtils.getConnection();
			ArrayList<Student> list = new ArrayList<Student>();
			String sql = "select id,name from student limit ?,?";
		
			st = conn.prepareStatement(sql);
			st.setObject(1, startIndex );
			st.setObject(2, pagesize);
			rs = st.executeQuery();
			while(rs.next()){
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				list.add(student);
			}
			return list;
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			utils.JdbcUtils.release(conn, st, rs);
		}
	}

	
	
	
	
	
	
	
	
	
	

}
