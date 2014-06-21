package daoImpl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import utils.JdbcUtils;
import dao.PersonDao;
import domain.Person;

public class PersonDaoImpl implements PersonDao {
	
	/* (non-Javadoc)
	 * @see daoImpl.PersonDao#add(domain.Person)
	 */
	@Override
	public void add(Person p) throws SQLException{
		//1. get person in person table
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "insert into person(id,name) values(?,?)";
		Object[] params = {p.getId(), p.getName()};
		qr.update(sql, params);
		
		//2. get idcard in person table
		sql = "insert into idcard(id, address) values(?,?)";
		Object[] params2 = {p.getId(), p.getIdcard().getAddress()};
		qr.update(sql, params2);
	}
	
}
