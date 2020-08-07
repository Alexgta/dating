package com.job4j.dating.service;

import com.job4j.dating.dao.MaritalStatusRepository;
import com.job4j.dating.entity.dict.MaritalStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class MaritalStatusServiceImpl implements MaritalStatusService {

	private final MaritalStatusRepository theMaritalStatusRepository;

	@Autowired
	public MaritalStatusServiceImpl(MaritalStatusRepository pMaritalStatusRepository) {
		theMaritalStatusRepository = pMaritalStatusRepository;
	}

	@Override
	public List<MaritalStatus> findAll() {
		return theMaritalStatusRepository.findAll();
	}

	@Override
	public List<MaritalStatus> findCurrent(String language, String gender) {
		return theMaritalStatusRepository.findByLanguageAndGender(language, gender);
	}

	@Override
	public MaritalStatus findById(int theId) {
		Optional<MaritalStatus> result = theMaritalStatusRepository.findById(theId);

		MaritalStatus theMaritalStatus = null;

		if (result.isPresent()) {
			theMaritalStatus = result.get();
		} else {
			// we didn't find the customer
			throw new RuntimeException("Did not find MaritalStatus with id = " + theId);
		}

		return theMaritalStatus;
	}

	@Override
	public void save(MaritalStatus theMaritalStatus) {
		theMaritalStatusRepository.save(theMaritalStatus);
	}

	@Override
	public void deleteById(int theId) {
		theMaritalStatusRepository.deleteById(theId);
	}

}

