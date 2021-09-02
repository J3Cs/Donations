/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j3cs.Telus.donations.dao;

import com.j3cs.Telus.donations.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author juliocardona
 */
@Repository
public interface IUserDao extends JpaRepository<User, Integer> {
    @Query(nativeQuery = false, value = "SELECT u FROM User u WHERE email = ?1")
    public User findByEmail(String email); 
}
