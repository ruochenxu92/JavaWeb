package dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import utils.JdbcUtils;
import domain.Role;
import domain.User;

public class UserDao {

	public void add(User user){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into user values(?,?,?)";
			Object[] params = {user.getId(), user.getUsername(),user.getPassword()};
			qr.update(sql, params);
		}catch(Exception e){
			throw new RuntimeException(e);
		}	
	}
	
	public User find(String user_id) {
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user where id=?";
			return (User) qr.query(sql, user_id, new BeanHandler(User.class));

		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public User find(String username, String password){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user where username=? and password=?";
			Object[] params = {username, password};
			return (User) qr.query(sql, params, new BeanHandler(User.class));
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}	
		
	}
	
	
	public List getAll(){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user";
			return (List) qr.query(sql, new BeanListHandler(User.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}	
		
		
	}
	
	public List<Role> getUserRoles(String user_id){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select r.* from user_role ur,role where ur.user_id=? and role.id = ur.role_id";
			return (List<Role>) qr.query(sql, user_id, new BeanListHandler(Role.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}	
	}
	
	public void updateUserRole(User user,List<Role> roles){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			
			//Delete User current role and then add new roles to the current user
			String sql = "delete from user_role where user_id=?";
			qr.update(sql, user.getId());
			
			
			sql = "insert into user_role(user_id, role_id) vqlues(?,?)";
			Object[][] params = new Object[roles.size()][];
			int index = 0;
			for(Role r : roles){
				params[index++] = new Object[]{ user.getId(),  r.getId() };
			}
			qr.batch(sql, params);
		}catch(Exception e){
			throw new RuntimeException(e);
		}		
	}

	public void deleteAll(User user) {
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "delete from user_role where user_id =?";
			qr.update(sql, user.getId());
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
