package us;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class demo2 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password = "root";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
	
		try{
		//1.º”‘ÿ«˝∂Ø
			Class.forName("com.mysql.jdbc.Driver");

			DriverManager.registerDriver(new com.mysql.jdbc.Driver());

			// 2.ªÒ»°”Î ˝æ›ø‚µƒ¡¥Ω”
			conn = DriverManager.getConnection(url, username, password);

			// 3.ªÒ»°”√”⁄œÚ ˝æ›ø‚∑¢ÀÕsql”Ôæ‰µƒstatement
			st = conn.createStatement();

			// 4.œÚ ˝æ›ø‚∑¢sql,≤¢ªÒ»°¥˙±ÌΩ·π˚ºØµƒresultset
			String sql = "select name,password,email,birthday from users";
			rs = st.executeQuery(sql);

			// 5.»°≥ˆΩ·π˚ºØµƒ ˝æ›
			while (rs.next()) {
				System.out.println("name=" + rs.getString("name"));
				System.out.println("password=" + rs.getString("password"));
				System.out.println("email=" + rs.getString("email"));
				System.out.println("birthday=" + rs.getDate("birthday"));
			}
		}finally{
		//6.πÿ±’¡¥Ω”£¨ Õ∑≈◊ ‘¥
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
}