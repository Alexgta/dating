package com.job4j.dating.service;


import com.job4j.dating.entity.dict.MaxCityName;
import java.util.List;


public interface MaxCityNameService {

    public List<MaxCityName> findAll();

    public List<MaxCityName> findByCityNameStart(String countryId, String CityNameStart, String language);

    public MaxCityName findById(int theId);

    public void save(MaxCityName theAd);

    public void deleteById(int theId);

}
