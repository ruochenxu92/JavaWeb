package dao;

import java.sql.SQLException;

import domain.Person;

public interface PersonDao {

	void add(Person p) throws SQLException;

}