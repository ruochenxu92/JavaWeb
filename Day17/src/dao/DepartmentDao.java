package dao;

import java.sql.SQLException;

import domain.Department;

public interface DepartmentDao {

	void add(Department department) throws SQLException;

	Department find(String id) throws SQLException;

}