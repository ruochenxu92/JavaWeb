package demo;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.Test;

import utils.JdbcUtils_DBCP;

public class demo4 {

	
	@Test
	public void demo(){
		
		try{
			Connection conn = JdbcUtils_DBCP.getConnection();
			PreparedStatement st = null;
			String sql = "select name,money from account ";
			st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			ResultSetMetaData metadata = st.getMetaData();
			System.out.println(metadata.getColumnCount());
			System.out.println(metadata.getColumnName(1));
			//ParameterMetaData pm = st.getParameterMetaData();
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}	
