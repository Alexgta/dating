package com.job4j.dating.service;

import com.job4j.dating.entity.Customer;
import java.util.List;


public interface CustomerService {

	public List<Customer> findAll();
	
	public Customer findById(int theId);
	
	public void save(Customer theCustomer);
	
	public void deleteById(int theId);
	
}
