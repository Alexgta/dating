package com.job4j.dating.dao;

import com.job4j.dating.entity.dict.MaxCityName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MaxCityNameRepository extends JpaRepository<MaxCityName, Integer> {

    public List<MaxCityName> findAll();

    @Query("SELECT nm FROM MaxCityName nm, MaxCity ct WHERE nm.cityId = ct.id AND ct.countryId = :countryId " +
           " AND nm.cityName like :cityNameStart AND nm.language = :language")
    public List<MaxCityName> findByCityNameStart(@Param("countryId") String countryId,
                                                 @Param("cityNameStart") String cityNameStart,
                                                 @Param("language") String language);

}
