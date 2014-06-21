package day15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class Demo1 {
	
	public static void main(String[] args){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
	
		try{
			conn = JdbcUtils.getConnection();
			String sql = "insert into testclob(resume) values(?)";
			st = conn.prepareStatement(sql);
		     
			
			String uri = Demo1.class.getClassLoader().getResource("1.txt").getPath();
			File file = new File(uri);
			st.setCharacterStream(1, new FileReader(file), (int) file.length());
			
			int num = st.executeUpdate();
			
			if(num > 0) {
				System.out.println("insert successfully!");
			}
		}catch(Exception e){
			e.printStackTrace();
		
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		
	}
	
	@Test
	public void readblob(){
		Connection conn = null;
		PreparedStatement st= null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			String sql = "select image from testblob where id=?";
			st = conn.prepareStatement(sql);
			st.setInt(1, 1);
			rs = st.executeQuery();
			if(rs.next()){
				InputStream in  = rs.getBinaryStream("image");
				int len = 0;
				byte buffer[] = new byte[1024];
				
				FileOutputStream out = new FileOutputStream("/Users/Xiaomin/Desktop/test.jpg");

				while((len=in.read(buffer))> 0){
					out.write(buffer,0,len);
				}
				in.close();
				out.close();	
			}	
		}catch(Exception e){
			e.printStackTrace();
		
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		
	}
	
	
	@Test
	public void add(){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			String sql = "insert into testblob(image) values(?)";
			st = conn.prepareStatement(sql);
			
			String path = Demo1.class.getClassLoader().getResource("1.jpg").getPath();
			st.setBinaryStream(1, new FileInputStream(path), (int) new File(path).length());
			int num = st. executeUpdate();
			if( num > 0){
				System.out.println("insert successfully");
			}
		}catch(Exception e){
			e.printStackTrace();
		
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		
		
	}
	
	
	@Test
	public void read(){
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
	
		try{
			conn = JdbcUtils.getConnection();
			String sql = "select resume from testclob where id=?";
			st = conn.prepareStatement(sql);
			st.setInt(1, 1);
			rs = st.executeQuery();
			if(rs.next()){
				Reader reader = rs.getCharacterStream("resume");
				char buffer[]  = new char[1024];
				int len = 0;
				FileWriter out = new FileWriter("/Users/Xiaomin/Desktop/1.txt");
				while((len = reader.read(buffer))>0){
					out.write(buffer,0,len);
				}
				out.close();
				reader.close();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		
		}finally{
			JdbcUtils.release(conn, st, rs);
		}	
	}
	
	
}
