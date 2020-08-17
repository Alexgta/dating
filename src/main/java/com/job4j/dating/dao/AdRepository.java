package com.job4j.dating.dao;

import com.job4j.dating.entity.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface AdRepository extends JpaRepository<Ad, Integer> {

    public List<Ad> findAll();
	
}
