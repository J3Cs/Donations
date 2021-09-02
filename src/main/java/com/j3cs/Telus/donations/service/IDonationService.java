/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j3cs.Telus.donations.service;

import com.j3cs.Telus.donations.domain.Donation;
import java.util.List;

/**
 *
 * @author juliocardona
 */
public interface IDonationService {
    public List<Donation> listAll();
    public void save(Donation donation);
    public void delete(Donation donation);
    public Donation findDonation(Donation donation);
}
