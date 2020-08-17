package com.job4j.dating.service;

import com.job4j.dating.dao.maxCountryRepository;
import com.job4j.dating.entity.dict.MaxCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class MaxCountryServiceImpl implements MaxCountryService {

    private final maxCountryRepository theMaxCountryRepository;

    @Autowired
    public MaxCountryServiceImpl(maxCountryRepository theMaxCountryRepository) {
        this.theMaxCountryRepository = theMaxCountryRepository;
    }

    /*@Override
    public List<MaxCountry> findAll() {
        return theMaxCountryRepository.findAll();
    }*/

    @Override
    public List<MaxCountry> findRegionCountries(String language) {
        return theMaxCountryRepository.findByLanguageOrderByCountryName(language);
    }

    @Override
    public MaxCountry findById(String theId) {
        Optional<MaxCountry> result = theMaxCountryRepository.findById(theId);
        MaxCountry theMaxCountry = null;

        if (result.isPresent()) {
            theMaxCountry = result.get();
        } else {
            // we didn't find Name
            throw new RuntimeException("Did not find Country_name with id = " + theId);
        }

        return theMaxCountry;
    }

    @Override
    public void save(MaxCountry theAd) {
        theMaxCountryRepository.save(theAd);
    }

    @Override
    public void deleteById(String theId) {
        theMaxCountryRepository.deleteById(theId);
    }

}
