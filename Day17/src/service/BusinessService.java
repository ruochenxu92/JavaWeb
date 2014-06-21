package service;

import java.sql.SQLException;

import org.junit.Test;

import dao.DepartmentDao;
import dao.PersonDao;
import dao.TeacherDao;
import daoImpl.PersonDaoImpl;
import daoImpl.TeacherDaoImpl;
import domain.Idcard;
import domain.Person;
import domain.Student;
import domain.Teacher;

public class BusinessService {
	private PersonDao pdao = utils.DaoFactory.createDao("dao.PersonDao", PersonDao.class);
	private TeacherDao tdao = utils.DaoFactory.createDao("dao.TeacherDao", TeacherDao.class);
	private DepartmentDao ddao = utils.DaoFactory.createDao("dao.DaoFactory", DepartmentDao.class);
	
	@Test
	public void addTeacher() throws SQLException{
		
		Teacher t = new Teacher();
		
		t.setId("1");
		t.setName("Dong");
		t.setSalary(600000);
		
		Student s1 = new Student();
		s1.setId("1");
		s1.setName("Bill");

		Student s2 = new Student();
		s2.setId("2");
		s2.setName("Sarah");
		
		t.getStudents().add(s1);
		t.getStudents().add(s2);
		
	
		tdao.add(t);
	
	}
	
	@Test
	public void findTeacher() throws SQLException{
		Teacher t = tdao.find("1");
		System.out.println(t);
	}
	
	@Test
	public void addPerson() throws SQLException{
		
		Person p = new Person();
		p.setId("1");
		p.setName("Xiaomin");
		
		Idcard id = new Idcard();
		id.setId("1");
		id.setAddress("Champaign");
		
		p.setIdcard(id);
		
		pdao.add(p);
	}
	
}
