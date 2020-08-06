package com.job4j.dating.service;


import com.job4j.dating.entity.dict.MaritalStatus;
import java.util.List;


public interface MaritalStatusService {

    public List<MaritalStatus> findAll();

    public MaritalStatus findById(int theId);

    public void save(MaritalStatus theMaritalStatus);

    public void deleteById(int theId);

}
