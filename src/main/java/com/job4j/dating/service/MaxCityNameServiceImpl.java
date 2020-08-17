package com.job4j.dating.service;

import com.job4j.dating.dao.MaxCityNameRepository;
import com.job4j.dating.entity.dict.MaxCityName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;


@Service
public class MaxCityNameServiceImpl implements MaxCityNameService {

    private final MaxCityNameRepository theMaxCityNameRepository;
    private EntityManager em;

    @Autowired
    public MaxCityNameServiceImpl(MaxCityNameRepository pTheMaxCityNameRepository) {
        this.theMaxCityNameRepository = pTheMaxCityNameRepository;
    }

    @Override
    public List<MaxCityName> findAll() {
        return theMaxCityNameRepository.findAll();
    }

    @Override
    public List<MaxCityName> findByCityNameStart(String countryId, String CityNameStart, String language) {

        return theMaxCityNameRepository.findByCityNameStart(countryId, CityNameStart, language);
    }

    @Override
    public MaxCityName findById(int theId) {
        Optional<MaxCityName> result = theMaxCityNameRepository.findById(theId);
        MaxCityName theMaxCityName = null;

        if (result.isPresent()) {
            theMaxCityName = result.get();
        } else {
            // we didn't find Name
            throw new RuntimeException("Did not find CityName with id = " + theId);
        }

        return theMaxCityName;
    }

    @Override
    public void save(MaxCityName theMaxCityName) {
        theMaxCityNameRepository.save(theMaxCityName);
    }

    @Override
    public void deleteById(int theId) {
        theMaxCityNameRepository.deleteById(theId);
    }

}
