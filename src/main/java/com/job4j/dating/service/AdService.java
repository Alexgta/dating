package com.job4j.dating.service;

import com.job4j.dating.entity.Ad;
import java.util.List;


public interface AdService {

    public List<Ad> findAll();

    public Ad findById(int theId);

    public void save(Ad theAd);

    public void deleteById(int theId);

}
