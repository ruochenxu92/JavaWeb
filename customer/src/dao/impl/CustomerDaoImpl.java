package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import utils.JdbcUtils;
import domain.Customer;
import exception.UserDaoException;

public class CustomerDaoImpl {
//	private String id;
//	private String name;
//	private String gender;
//	private Date birthday;
//	private String cellphone;
//	private String email;
//	private String preference;
//	private String type;
//	private String description;
	public void add(Customer c){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into Customer(id, name,gender,cellphone,email,preference,type,description) values(?,?,?,?,?,?,?,?)";
			
			st = conn.prepareStatement(sql);
			st.setString(1, c.getId());
			st.setString(2, c.getName());
			st.setString(3, c.getGender());

			st.setString(5, c.getCellphone());
			st.setString(6, c.getEmail());
			st.setString(7, c.getPreference());
			st.setString(8, c.getType());
			st.setString(9, c.getDescription());
			st.executeUpdate(sql);

		} catch (SQLException e) {	
			throw new UserDaoException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		
	}
	
	public void delete(Customer c){
		
	}
	
	public void update(Customer c){
		
	}
	
	public Customer find(Customer c){
		return null;
		
	}
	
	public List<Customer> findAll(){
		return null;
	}
	
	
	
	
}
