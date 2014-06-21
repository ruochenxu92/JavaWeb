package domain;

import java.util.HashSet;
import java.util.Set;

public class Privilege {
	
	private String id;
	private String name;
	private String description;
//	private Set roles = new HashSet(); there is no need to setup the authority
//	private Set users = new HashSet();
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

		
}
