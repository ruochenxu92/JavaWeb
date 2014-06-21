package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PrivilegeDao;
import dao.RoleDao;
import dao.UserDao;
import domain.Privilege;
import domain.Role;
import domain.User;

public class SecurityService {
	private static PrivilegeDao pdao = new PrivilegeDao();
	private static RoleDao rdao = new RoleDao();
	private static UserDao udao = new UserDao();
	
	
	public void addPrivilege(Privilege p){	
		pdao.add(p);
	}
	
	public Privilege findPrivilege(String id){
		return pdao.find(id);
	}
	
	public List<Privilege> getAllPrivilege(){
		return pdao.getAll();
	}

	//对web层提供add Role service
	public void addRole(Role role){
		rdao.add(role);
	}
	
	public Role findRole(String id){
		return rdao.find(id);
	}
	
	public List<Privilege> getRolePrivilege(String role_id){
		return rdao.getRolePrivilege(role_id);
	}
	
	public List<Role> getAllRole(){
		return rdao.getAll();
	}

	public List<User> getAllUser(){
		return udao.getAll();
	}
	
	
	public void updateRolePrivilege(String role_id, String[] privilege_ids) throws SQLException {
		Role role = rdao.find(role_id);
		List<Privilege> list = new ArrayList();

		rdao.deleteAll(role);
		System.out.println("Delete Successfully");
		
		for(String pid : privilege_ids){
			Privilege p = pdao.find(pid);
			System.out.println(p);
			list.add(p);
		}
		
		rdao.updateRolePrivilege(role, list);
	}
	
	
	public void addUser(User user){
		udao.add(user);
	}
	
	public User findUser(String user_id){
		return udao.find(user_id);
	}

	public void updateUserRole(String user_id, String[] role_ids) {
		User user = udao.find(user_id);
		List<Role> roles = new ArrayList();
		
//		udao.deleteAll(user);
		udao.deleteAll(user);
		
		for(String r : role_ids){
			Role role = rdao.find(r);
			roles.add(role);
		}
		udao.updateUserRole(user, roles);

	}

	public List getUserRole(String user_id) {
		return udao.getUserRoles(user_id);
		
	}
	
	
	
	
}
