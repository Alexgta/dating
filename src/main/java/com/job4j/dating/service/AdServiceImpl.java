package com.job4j.dating.service;

import com.job4j.dating.dao.AdRepository;
import com.job4j.dating.entity.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class AdServiceImpl implements AdService {

	private final AdRepository theAdRepository;

	@Autowired
	public AdServiceImpl(AdRepository pAdRepository) {
		theAdRepository = pAdRepository;
	}

	@Override
	public List<Ad> findAll() {
		return theAdRepository.findAll();
	}

	@Override
	public Ad findById(int theId) {
		Optional<Ad> result = theAdRepository.findById(theId);

		Ad theAd = null;

		if (result.isPresent()) {
			theAd = result.get();
		} else {
			// we didn't find the customer
			throw new RuntimeException("Did not find Ad with id = " + theId);
		}

		return theAd;
	}

	@Override
	public void save(Ad theAd) {
		theAdRepository.save(theAd);
	}

	@Override
	public void deleteById(int theId) {
		theAdRepository.deleteById(theId);
	}

}

