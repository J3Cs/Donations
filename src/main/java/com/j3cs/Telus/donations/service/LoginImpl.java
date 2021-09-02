/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j3cs.Telus.donations.service;

import com.j3cs.Telus.donations.dao.IUserDao;
import com.j3cs.Telus.donations.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author juliocardona
 */
@Service
public class LoginImpl implements ILoginService{

    @Autowired
    IUserDao userDao;
    
    @Override
    @Transactional(readOnly = true)
    public User getUserByEmail(User user) {
        return userDao.findByEmail(user.getEmail());
    }
    
}
