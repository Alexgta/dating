package com.job4j.dating.dao;


import com.job4j.dating.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	// no need to write any code!

    public List<Customer> findAllByOrderByLastNameAsc();
	
}
