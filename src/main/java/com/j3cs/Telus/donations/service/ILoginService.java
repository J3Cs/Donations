/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j3cs.Telus.donations.service;

import com.j3cs.Telus.donations.domain.User;

/**
 *
 * @author juliocardona
 */

public interface ILoginService {
    
    public User getUserByEmail(User user);
}
