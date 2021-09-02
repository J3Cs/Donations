/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j3cs.Telus.donations.service;

import com.j3cs.Telus.donations.domain.Institution;
import java.util.List;

/**
 *
 * @author juliocardona
 */
public interface IInstitutionService {
    public List<Institution> listAll();
    public void save(Institution institution);
    public void delete(Institution institution);
    public Institution findInstitution(Institution institution);
}
