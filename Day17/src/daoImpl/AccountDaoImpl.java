package daoImpl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import dao.AccountDao;
import demo.JdbcUtils;
import domain.Account;

public class AccountDaoImpl implements AccountDao {

	private Connection conn = null;
	
	public AccountDaoImpl(Connection conn){
		this.conn = conn;
	}
	
	public AccountDaoImpl(){
		
	}
	
	/*public void transfer(int sourceid,int targetid,float money) throws SQLException{
		
		Connection conn = null;
		try{
		
			conn = JdbcUtils.getConnection();
			conn.setAutoCommit(false);
			
			QueryRunner runner = new QueryRunner();
			String sql1 = "update account set money=money-100 where id=1";
			runner.update(conn,sql1);
			
			
			String sql2 = "update account set money=money+100 where id=2";
			runner.update(conn,sql2);
			
			conn.commit();
		}catch (Exception e) {
			if(conn!=null)
				conn.rollback();
		}finally{
			conn.close();
		}
		
	}*/
	
	/* (non-Javadoc)
	 * @see dao.impl.AccountDao#update(domain.Account)
	 */
	/* (non-Javadoc)
	 * @see daoImpl.AccountDao#update(domain.Account)
	 */
	@Override
	public void update(Account account) throws SQLException{
		
		QueryRunner qr = new QueryRunner();
		String sql = "update account set name=?,money=? where id=?";
		Object params[] = {account.getName(),account.getMoney(),account.getId()};
		qr.update(JdbcUtils.getConnection(),sql, params);
		
	}
	
	/* (non-Javadoc)
	 * @see cn.dao.impl.AccountDao#find(int)
	 */
	/* (non-Javadoc)
	 * @see daoImpl.AccountDao#find(int)
	 */
	@Override
	public Account find(int id) throws SQLException{
		QueryRunner qr = new QueryRunner();
		String sql = "select * from account where id=?";
		return (Account) qr.query(JdbcUtils.getConnection(),sql, id, new BeanHandler(Account.class));
	}
}

//public void transfer(int sourceid, int targetid, float money) throws SQLException{
//	Connection conn = null;
//	try{
//		conn = JdbcUtils.getConnection();
//		conn.setAutoCommit(false);
//		QueryRunner runner = new QueryRunner();
//
//		// 不要给它Connection
//		String sql = "update account set money=money-100 where id=1";
//		runner.update(sql);
//
//		String sql2 = "update account set money=money+100 where id=2";
//		runner.update(sql2);
//
//		conn.commit();
//		
//	}catch(Exception e){
//		if(conn!=null){
//			conn.rollback();
//		}
//	}finally{
//		conn.close();
//	}
//
//}
//