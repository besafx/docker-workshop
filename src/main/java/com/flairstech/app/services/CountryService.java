package com.flairstech.app.services;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.flairstech.app.domain.Country;

@Service
@Transactional
public interface CountryService extends PagingAndSortingRepository<Country, Long>, JpaSpecificationExecutor<Country> {

	Optional<Country> findByCode(String code);
}