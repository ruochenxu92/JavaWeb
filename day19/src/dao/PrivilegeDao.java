package dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import utils.JdbcUtils;
import domain.Privilege;

public class PrivilegeDao {

	public void add(Privilege p){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into privilege(id,name,description) values(?,?,?)";
			Object[] params = {p.getId(),p.getName(),p.getDescription()};
			qr.update(sql, params);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
	
	
	public Privilege find(String id){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select id, name,description from privilege where id=?";
			return (Privilege) qr.query(sql, id, new BeanHandler(Privilege.class));

		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Privilege> getAll(){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select id,name,description from privilege";
			return (List<Privilege>) qr.query(sql, new BeanListHandler(Privilege.class));
		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
	
	
	
	
}
