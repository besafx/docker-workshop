package com.flairstech.app.services;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.flairstech.app.domain.City;

@Service
@Transactional
public interface CityService extends PagingAndSortingRepository<City, Long>, JpaSpecificationExecutor<City> {


}