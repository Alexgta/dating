package com.job4j.dating.service;

import com.job4j.dating.entity.dict.MaxCity;
import java.util.List;

public interface MaxCityService {

    public List<MaxCity> findAll();

    public List<MaxCity> findByCountryId(String theCountryId);

    public MaxCity findById(int theId);

    public void save(MaxCity theAd);

    public void deleteById(int theId);

}
