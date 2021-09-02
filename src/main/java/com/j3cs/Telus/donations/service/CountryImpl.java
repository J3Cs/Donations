/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j3cs.Telus.donations.service;

import com.j3cs.Telus.donations.dao.ICountryDao;
import com.j3cs.Telus.donations.domain.Country;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author juliocardona
 */
@Service
public class CountryImpl implements ICountryService{
    @Autowired
    private ICountryDao countryDao;

    @Override
    @Transactional(readOnly = true)
    public List<Country> listAll() {
        return (List<Country>) countryDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public void save(Country country) {
        countryDao.save(country);
    }

    @Override
    @Transactional(readOnly = true)
    public void delete(Country country) {
        countryDao.delete(country);
    }

    @Override
    @Transactional(readOnly = true)
    public Country findCountry(Country country) {
        return countryDao.getById(country.getIdCountry());
    }
  
}
