package DB;

import java.util.ArrayList;
import java.util.List;

import domain.User;

public class MyDb {
	private static List list = new ArrayList();
	
	static{
		list.add(new User("aaa", "123"));
		list.add(new User("bbb", "123"));
		list.add(new User("ccc", "123"));
	}
	
	public static List getAll(){
		return list;
	}

}
