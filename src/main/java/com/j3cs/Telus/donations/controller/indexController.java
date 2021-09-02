/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j3cs.Telus.donations.controller;

import com.j3cs.Telus.donations.dao.IUserDao;
import com.j3cs.Telus.donations.domain.User;
import com.j3cs.Telus.donations.service.IUserService;
import com.j3cs.Telus.donations.util.encriptarPassword;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author juliocardona
 */
@Controller
@Slf4j
public class indexController {
    
    @Autowired
    private IUserService userService;
    @Autowired
    private IUserDao userDao;
    
    @GetMapping({"/", "/login"})
    public String page(Model model) {
        return "index";
    }
    
    @GetMapping("/inicio")
    public String test() {
        return "inicio";
    }
    
    @GetMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("newUser", user);
        return "userRegister";
    }
    
    @PostMapping("/save")
    public String save(User user) {
        User userVerify = userDao.findByEmail(user.getEmail());
        if(user == null){
            return "userRegister";
        }
        if(userVerify != null){
            return "userRegister";
        }
        user.setPassword(encriptarPassword.encryptPassword(user.getPassword()));
        userService.save(user);
        return "inicio";
    }
    
    @GetMapping("/error")
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }
    
}
