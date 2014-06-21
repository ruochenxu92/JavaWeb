package daoImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.TeacherDao;
import domain.Student;
import domain.Teacher;
import utils.JdbcUtils;

public class TeacherDaoImpl implements TeacherDao {

		
	/* (non-Javadoc)
	 * @see daoImpl.TeacherDao#add(domain.Teacher)
	 */
	@Override
	public void add(Teacher t) throws SQLException{
		QueryRunner qr= new QueryRunner(JdbcUtils.getDataSource());
		
		
		//insert into teacher table
		String sql = "insert into teacher(id, name, salary) values(?,?,?)";
		Object[] params = {t.getId(), t.getName(), t.getSalary()};
		qr.update(sql, params);
		
		//insert into student table
		String sql2 = "insert into student(id, name) values(?,?)";
		String sql3 = "insert into teacher_student(teacher_id,student_id) values(?,?)";

		Set<Student> set = t.getStudents();
		Object[][] params2 = new Object[set.size()][];
		Object[][] params3 = new Object[set.size()][];
		int index = 0;
		for(Student s : set){
			params2[index] = new Object[]{s.getId(),s.getName()};
			//insert the middle table
			params3[index] = new Object[]{t.getId(), s.getId()};
			index++;
		}
		qr.batch(sql2, params2);
		qr.batch(sql3, params3);
		System.out.println("success!");
		
	}
	
	
	/* (non-Javadoc)
	 * @see daoImpl.TeacherDao#find(java.lang.String)
	 */
	@Override
	public Teacher find(String id) throws SQLException{
		Teacher t;
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from teacher where id=?";
		
		t = (Teacher) qr.query(sql, id, new BeanHandler(Teacher.class));
		
		
		//sql = "select * from teacher_student where teacher_id=?";
		sql = "select s.id,s.name from teacher_student as ts, student as s where teacher_id=? and ts.student_id = s.id";
		List list = (List) qr.query(sql, id, new BeanListHandler(Student.class));
		t.getStudents().addAll(list);
		System.out.println("success ^>^");
		return t;
		
	}

	
	
	
	
	
}
