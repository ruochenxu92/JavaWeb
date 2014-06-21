package service.impl;

import dao.impl.CustomerDaoImpl;
import domain.Customer;

public class BusinessService {

	CustomerDaoImpl dao = new CustomerDaoImpl();
	
	
	public void addCustomer(Customer customer){
		dao.add(customer);
	}
	
	
	

}
