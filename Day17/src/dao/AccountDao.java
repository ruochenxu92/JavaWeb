package dao;

import java.sql.SQLException;

import domain.Account;

public interface AccountDao {

	/* (non-Javadoc)
	 * @see dao.impl.AccountDao#update(domain.Account)
	 */
	void update(Account account) throws SQLException;

	/* (non-Javadoc)
	 * @see cn.dao.impl.AccountDao#find(int)
	 */
	Account find(int id) throws SQLException;

}