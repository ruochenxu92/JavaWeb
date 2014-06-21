package dao;

import java.sql.SQLException;

import domain.Teacher;

public interface TeacherDao {

	void add(Teacher t) throws SQLException;

	Teacher find(String id) throws SQLException;

}