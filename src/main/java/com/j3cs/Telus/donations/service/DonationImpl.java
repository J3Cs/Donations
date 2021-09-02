/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j3cs.Telus.donations.service;

import com.j3cs.Telus.donations.dao.IDonationDao;
import com.j3cs.Telus.donations.domain.Donation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author juliocardona
 */
@Service
public class DonationImpl implements IDonationService{
    @Autowired
    private IDonationDao donationDao;

    @Override
    @Transactional(readOnly = true)
    public List<Donation> listAll() {
        return (List<Donation>) donationDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public void save(Donation donation) {
        donationDao.save(donation);
    }

    @Override
    @Transactional(readOnly = true)
    public void delete(Donation donation) {
        donationDao.delete(donation);
    }

    @Override
    @Transactional(readOnly = true)
    public Donation findDonation(Donation donation) {
        return donationDao.getById(donation.getIdDonation());
    }
  
}
