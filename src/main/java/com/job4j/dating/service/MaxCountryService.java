package com.job4j.dating.service;

import com.job4j.dating.entity.dict.MaxCountry;
import java.util.List;


public interface MaxCountryService {

    //public List<MaxCountry> findAll();

    List<MaxCountry> findRegionCountries(String language);

    public MaxCountry findById(String theId);

    public void save(MaxCountry theAd);

    public void deleteById(String theId);

}
