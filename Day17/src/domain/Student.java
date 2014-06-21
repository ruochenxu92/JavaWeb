package domain;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private String id;
	private String name;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Teacher> getSet() {
		return set;
	}

	public void setSet(Set<Teacher> set) {
		this.set = set;
	}

	private Set<Teacher> set = new HashSet();
}
