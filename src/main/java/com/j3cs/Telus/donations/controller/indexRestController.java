/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j3cs.Telus.donations.controller;

import com.j3cs.Telus.donations.dao.IUserDao;
import com.j3cs.Telus.donations.domain.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author juliocardona
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class indexRestController {
    
    @Autowired
    private IUserDao userDao;
    
    
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUser(){
        return (List<User>) userDao.findAll();
    }
}
