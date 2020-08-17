package com.job4j.dating.dao;

import com.job4j.dating.entity.dict.MaxCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface maxCountryRepository extends JpaRepository<MaxCountry, String> {

    public List<MaxCountry> findAll();

    public List<MaxCountry> findByLanguageOrderByCountryName(String language);


}
