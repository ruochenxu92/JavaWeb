package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import utils.JdbcUtils;
import domain.Privilege;
import domain.Role;

public class RoleDao {
	
	public void add(Role role){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into role(id,name, description) values(?,?,?)";
			Object[] params = {role.getId(), role.getName(),role.getDescription()};
			qr.update(sql, params);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public Role find(String id){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select id,name,description from role where id=?";
			return (Role) qr.query(sql, id, new BeanHandler(Role.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Privilege> getRolePrivilege(String role_id){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select p.* from role_privilege rp, privilege p where role_id=? and rp.privilege_id=p.id";
			return (List<Privilege>) qr.query(sql, role_id, new BeanListHandler(Privilege.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Role> getAll(){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from role";
			return (List<Role>) qr.query(sql, new BeanListHandler(Role.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	//in order to give authority to specific role, 为某个角色赋值
	public void updateRolePrivilege(Role role, List<Privilege> privileges){
		try{
			System.out.println("role: " + role + " privileges: " + privileges);
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			Object[][] params = new Object[privileges.size()][];
			int index = 0;
			String sql = "insert into role_privilege values(?,?)";
			for (Privilege p : privileges) {
				params[index++] = new Object[] { role.getId(), p.getId() };
			}
			qr.batch(sql, params);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public void deleteAll(Role role) throws SQLException{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "delete from role_privilege where role_id=?";
		qr.update(sql, role.getId());
	}
	
}
