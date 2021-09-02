/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j3cs.Telus.donations.controller;

import com.j3cs.Telus.donations.service.PayPalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author juliocardona
 */
@Controller
public class PayPalController {
    
    @Autowired
    PayPalService service;
    
    @GetMapping("/donate")
    public String donate(){
        return "donate";
    }
    
}
