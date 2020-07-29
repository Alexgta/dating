package com.job4j.dating.service;

import com.job4j.dating.dao.CustomerRepository;
import com.job4j.dating.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository theCustomerRepository;

	@Autowired
	public CustomerServiceImpl(CustomerRepository pCustomerRepository) {
		theCustomerRepository = pCustomerRepository;
	}

	@Override
	public List<Customer> findAll() {
		return theCustomerRepository.findAll(); //ByOrderByLastNameAsc();
	}

	@Override
	public Customer findById(int theId) {
		Optional<Customer> result = theCustomerRepository.findById(theId);

		Customer theCustomer = null;

		if (result.isPresent()) {
			theCustomer = result.get();
		} else {
			// we didn't find the customer
			throw new RuntimeException("Did not find customer id - " + theId);
		}

		return theCustomer;
	}

	@Override
	public void save(Customer theCustomer) {
		theCustomerRepository.save(theCustomer);
	}

	@Override
	public void deleteById(int theId) {
		theCustomerRepository.deleteById(theId);
	}

}

