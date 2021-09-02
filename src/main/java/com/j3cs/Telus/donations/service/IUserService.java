/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j3cs.Telus.donations.service;

import com.j3cs.Telus.donations.domain.User;
import java.util.List;

/**
 *
 * @author juliocardona
 */
public interface IUserService {
    public List<User> listAll();
    public void save(User user);
    public void delete(User user);
    public User findUser(User user);
}
