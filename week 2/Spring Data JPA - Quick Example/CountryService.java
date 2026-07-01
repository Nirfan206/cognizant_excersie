package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.country;
import com.cognizant.orm_learn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<country> getAllCountries() {
        return countryRepository.findAll();
    }
}