package com.job4j.dating.dao;

import com.job4j.dating.entity.dict.MaritalStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MaritalStatusRepository extends JpaRepository<MaritalStatus, Integer> {

    public List<MaritalStatus> findAll();

}
