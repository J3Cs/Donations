/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j3cs.Telus.donations.dao;

import com.j3cs.Telus.donations.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author juliocardona
 */
public interface ICountryDao extends JpaRepository<Country, Integer> {
    
}
