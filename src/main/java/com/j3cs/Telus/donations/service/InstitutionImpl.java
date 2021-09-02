/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j3cs.Telus.donations.service;

import com.j3cs.Telus.donations.dao.IInstitutionDao;
import com.j3cs.Telus.donations.domain.Institution;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author juliocardona
 */
@Service
public class InstitutionImpl implements IInstitutionService{
    @Autowired
    private IInstitutionDao institutionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Institution> listAll() {
        return (List<Institution>) institutionDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public void save(Institution institution) {
        institutionDao.save(institution);
    }

    @Override
    @Transactional(readOnly = true)
    public void delete(Institution institution) {
        institutionDao.delete(institution);
    }

    @Override
    @Transactional(readOnly = true)
    public Institution findInstitution(Institution institution) {
        return institutionDao.getById(institution.getIdInstitution());
    }
  
}
