package com.cognizant.orm_learn.repository;

import com.cognizant.orm_learn.model.country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<country, String> {

}