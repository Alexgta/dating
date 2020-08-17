package com.job4j.dating.service;

import com.job4j.dating.dao.MaxCityRepository;
import com.job4j.dating.entity.dict.MaxCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MaxCityServiceImpl implements MaxCityService {

    private final MaxCityRepository theMaxCityRepository;

    @Autowired
    public MaxCityServiceImpl(MaxCityRepository theMaxCityRepository) {
        this.theMaxCityRepository = theMaxCityRepository;
    }

    @Override
    public List<MaxCity> findAll() {
        return theMaxCityRepository.findAll();
    }

    @Override
    public List<MaxCity> findByCountryId(String theCountryId) {
        return theMaxCityRepository.findByCountryId(theCountryId);
    }

    @Override
    public MaxCity findById(int theId) {

        Optional<MaxCity> result = theMaxCityRepository.findById(theId);
        MaxCity theMaxCity = null;

        if (result.isPresent()) {
            theMaxCity = result.get();
        } else {
            // we didn't find Name
            throw new RuntimeException("Did not find CityName with id = " + theId);
        }

        return theMaxCity;

    }

    @Override
    public void save(MaxCity theMaxCity) {
        theMaxCityRepository.save(theMaxCity);
    }

    @Override
    public void deleteById(int theId) {
        theMaxCityRepository.deleteById(theId);
    }

}
