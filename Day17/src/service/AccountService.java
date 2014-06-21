package service;

import java.sql.Connection;
import java.sql.SQLException;

import utils.JdbcUtils;
import dao.AccountDao;
import daoImpl.AccountDaoImpl;
import domain.Account;

public class AccountService {
	
	//ThreadLocal:
	public void transfer(int sourceid,int tartgetid,float money) throws SQLException{
		
		Connection conn = null;
		try{
		
			JdbcUtils.startTransaction();  //
			
			AccountDao dao = new AccountDaoImpl();
			
			Account source = dao.find(sourceid);
			Account target = dao.find(tartgetid);
			
			source.setMoney(source.getMoney()-money);
			target.setMoney(target.getMoney()+money);
			
			dao.update(source);
			int x = 1/0;
			dao.update(target);
			
			JdbcUtils.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			JdbcUtils.rollback();
		}finally{
			JdbcUtils.release();
		}
		
	}
	
}
