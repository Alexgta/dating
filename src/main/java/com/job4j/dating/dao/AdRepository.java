package com.job4j.dating.dao;


import com.job4j.dating.entity.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdRepository extends JpaRepository<Ad, Integer> {

	// no need to write any code!

    // add a method to sort by last name
    public List<Ad> findAll();
	
}
