package com.job4j.dating.dao;

import com.job4j.dating.entity.dict.MaxCity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface MaxCityRepository extends JpaRepository<MaxCity, Integer>  {

    public List<MaxCity> findAll();

    public List<MaxCity> findByCountryId(String countryId);

}
