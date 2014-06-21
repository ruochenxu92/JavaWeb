package us;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Demo1 {
	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password = "root";
		//1.load drive
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		//2.gain and database connect
		Connection conn = DriverManager.getConnection(url,username,password);

		//3. get statement for send sql
		Statement st = conn.createStatement();

		//4. sql
		String sql = "select netid,fullname,companyname from intern1";
		ResultSet rs = st.executeQuery(sql);
		
		//5. get result set
		while(rs.next()){
			System.out.println("netid=" + rs.getObject("netid"));
			System.out.println("fullname=" + rs.getObject("fullname"));
			System.out.println("companyname=" + rs.getObject("companyname"));
		}
		//6. close Connection total 20 connections
		rs.close();
		st.close();
		conn.close();
		
	}
}
