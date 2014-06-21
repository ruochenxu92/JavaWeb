package test;

import java.sql.SQLException;

import org.junit.Test;

import dao.DepartmentDao;
import daoImpl.DepartmentDaoImpl;
import domain.Department;
import domain.Employee;

public class DepartmentService {
	
	
	/*
	  create table department
	  (
	  		id varchar(40)j primary key,
	 		name varchar(40),

	  )
	  create table employee
	(
		id varchar(40) primary key, 
	  	name varchar(40),
	   salary double,
	   department_id varchar(40),
	   constraint department_id_FK foreign key(department_id) references department(id)
	  )
	 * 
	 * 
	 */
	@Test
	public void add() throws SQLException{
		Department d = new Department();
		d.setId("3");
		d.setName("engineer");
		
		Employee e1 = new Employee();
		e1.setId("1");
		e1.setName("aaa");
		e1.setSalary(300);
		
		Employee e2 = new Employee();
		e2.setId("2");
		e2.setName("bbb");
		e2.setSalary(300);
		
		d.getEmployees().add(e1);
		d.getEmployees().add(e2);
		
		DepartmentDao dao = new DepartmentDaoImpl();
		dao.add(d);
	}
	
	
	@Test
	public void find() throws SQLException{
		DepartmentDao dao = new DepartmentDaoImpl();
		Department d = dao.find("3");
		System.out.println(d);
		System.out.println("success");
	}
	
	
	
	
	
	
	
}
