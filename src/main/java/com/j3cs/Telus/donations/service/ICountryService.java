/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j3cs.Telus.donations.service;

import com.j3cs.Telus.donations.domain.Country;
import java.util.List;

/**
 *
 * @author juliocardona
 */
public interface ICountryService {
    public List<Country> listAll();
    public void save(Country country);
    public void delete(Country country);
    public Country findCountry(Country country);
}
