package demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.serial.SerialClob;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;



public class demo1{

	/*
	 * 
	 *  π”√dbutilsøÚº‹ÕÍ≥…curd,“‘º∞≈˙¥¶¿Ì
	 * 
	 create database day17; use day17;
	
	 create table user( id int primary key auto_increment, name varchar(40),
	 password varchar(40), email varchar(60), birthday date );
	 
	 
	 insert into user(name,password,email,birthday)values('zs','123456','zs@sina.com','1980-09-09'); 
	 insert into user(name,password,email,birthday) values('lisi','123456','lisi@sina.com','1980-09-09'); 
	 insert into user(name,password,email,birthday) values('wangwu','123456','wangwu@sina.com','1980-09-09');
	 * 
	 */

	@Test
	public void add() throws SQLException {

		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "insert into user(name,password,email,birthday) values(?,?,?,?)";
		Object params[] = { "ccc", "123", "cc@sina.com", "1992-07-24" };
		qr.update(sql, params);
	}
	
	@Test 
	public void delete() throws SQLException{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "delete  from user where id=?";
		Object params[] = {1};
		qr.update(sql,params);
	}
	
	@Test
	public void update() throws SQLException{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "update user set name=?  where id=?";
		Object[] params = {"Xiaomin", 2};
		qr.update(sql, params);
	}
	


	@Test
	public void find() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from user where id=?";
		Object params[] = { 2 };
		User user = (User) qr.query(sql, params, new BeanHandler(User.class));
		System.out.println(user.getBirthday());
	}
	
	
	
	
	

	@Test
	public void getAll() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from user";
		List list = (List) qr.query(sql, new BeanListHandler(User.class));
		System.out.println(list.size());
	}
	
	@Test
	public void testBatch() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "insert into user(name,password,email, birthday) values(?,?,?,?)";
		Object[][] params = new Object[10][];
		for (int i = 0; i < params.length; i++) {
			params[i] = new Object[] {"aaaa","123" ,"aaa@gmail.com", "1999-12-12"};
		}
		qr.batch(sql, params);
	}
	
	


//	// ”√dbutilsÕÍ≥…¥Û ˝æ›£®≤ªΩ®“È”√£©
//	/***************************************************************************
//	 create table testclob
//	 (
//	 	id int primary key auto_increment,
//	 	resume text
//	 );
//	 * @throws SQLException 
//	 * @throws IOException 
//	 **************************************************************************/
//	
//	@Test
//	public void testclob() throws SQLException, IOException{
//		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
//		String sql = "insert into testclob(resume) values(?)";  //clob
//		
//		
//		//ÃÊªª≤Œ ˝
//		/*String path = Demo1.class.getClassLoader().getResource("1.txt").getPath();
//		Object params[] = {new FileReader(path)};
//		*/
//		
//		String path = Demo1.class.getClassLoader().getResource("1.txt").getPath();
//		FileReader in = new FileReader(path);
//		char[] buffer = new char[(int) new File(path).length()];
//		in.read(buffer);
//		SerialClob clob = new SerialClob(buffer);
//		Object params[] = {clob};
//		runner.update(sql, params);
//	}
//	
}
