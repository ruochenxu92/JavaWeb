package demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import utils.BeanHandler;
import utils.BeanListHandler;
import utils.JdbcUtils;

public class AccountDao {
	
	public void add(Account account) throws Exception{
		String sql = "insert into account(name, money) values(?,?)";
		Object[] params = new Object[]{account.getName(),account.getMoney()};
		JdbcUtils.update(sql, params);
	}
	
	
//	@Test
//	public void testupdate() throws SQLException{
//		Account account = new Account();
//		account.setId(4);
//		account.setName("xiaomin");
//		account.setMoney(100000);
//		update(account);
//	}

	@Test 
	public void testdelete() throws Exception{
		delete(4);
	}
	
	public void update(Account account) throws Exception{
		String sql = "update account set name=?, money=? where id=?";
		Object[] params = new Object[]{account.getName(),account.getMoney(),account.getId()};
		JdbcUtils.update(sql, params);
	}
	
	public void delete(int id) throws Exception{
		String sql = "delete from account where id = ?";
		Object[] params = new Object[]{id};
		JdbcUtils.update(sql, params);
	}
	
	@Test
	public void testquery() throws Exception{
		int id = 2;
		System.out.println( find(1));
	}
	
	public Account find(int id) throws Exception{
		String sql = "select name,money from account where id=?";
		Object[] params = {id};
		return (Account) JdbcUtils.query(sql, params, new BeanHandler(Account.class));
	}
	
	
	@Test
	public void testfindall() throws Exception{
		List list = findAll();
		System.out.println(list);
	}
	
	
	public List findAll() throws Exception{
		String sql = "select name,money from account ";
		Object[] params = {};
		return (List) JdbcUtils.query(sql, params, new BeanListHandler(Account.class));
	}
	
	
	
}
