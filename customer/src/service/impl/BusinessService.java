package service.impl;

import dao.impl.CustomerDaoImpl;
import domain.Customer;

public class BusinessService {
	private CustomerDaoImpl dao = new CustomerDaoImpl();
	
	
	public void add(Customer customer){
		dao.add(customer);
	}
	
	
	
}
