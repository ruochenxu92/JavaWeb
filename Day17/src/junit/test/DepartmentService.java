package junit.test;

import org.junit.Test;

import domain.Department;
import domain.Employee;

public class DepartmentService {
	
	/*
	 * create table department
	 * (
	 * 	id varchar(40) primary key,
	 * 	name varchar(40)
	 * )
	 * 
	 * create table employee
	 * (
	 * 	id varchar(40) primary key,
	 * 	name varchar(40),
	 *  salary double
	 * )
	 * 
	 * 
	 * 
	 */
	
	
	@Test
	public void add(){
		Department d = new Department();
		d.setId("1");
		d.setName("Develop");
		
		Employee e1 = new Employee();
		e1.setId("2");
		e1.setName("aaa");
		e1.setSalary(300);
		
		
		Employee e2 = new Employee();
		e2.setId("3");
		e2.setName("bbb");
		e2.setSalary(300);
		
		

	}
	
	
	
}
