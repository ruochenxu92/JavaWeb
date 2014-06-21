package daoImpl;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import utils.JdbcUtils;
import dao.DepartmentDao;
import domain.Department;
import domain.Employee;

public class DepartmentDaoImpl implements DepartmentDao {
	
	
	/* (non-Javadoc)
	 * @see daoImpl.DepartmentDao#add(domain.Department)
	 */
	@Override
	public void add(Department department) throws SQLException{
		
	
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			
			String sql = "insert into department(id,name) values(?,?)";
			Object[] params = {department.getId(), department.getName()};
			qr.update(sql, params);
	
			
			sql = "insert into employee(id, name,salary, department_id) values(?,?,?,?)";
			Set<Employee> employees = department.getEmployees();
			Object[][] params2 = new Object[employees.size()][];
			int index = 0;
			for(Employee e : employees){
				params2[index] = new Object[]{e.getId(),e.getName(),e.getSalary(),department.getId()};
				index++;
			}
			qr.batch(sql, params2);
		
	}
	
	
	
	/* (non-Javadoc)
	 * @see daoImpl.DepartmentDao#find(java.lang.String)
	 */
	@Override
	public Department find(String id) throws SQLException{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		
		String sql = "select * from department where id=?";
		Department d = (Department) qr.query(sql, id, new BeanHandler(Department.class));
		
		
		sql = "select * from employee where department_id = ?";
		
		List list =  (List) qr.query(sql, id, new BeanListHandler(Employee.class));
		d.getEmployees().addAll(list);
		return d;
	}
	
}
	