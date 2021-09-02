/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j3cs.Telus.donations.service;

import com.j3cs.Telus.donations.dao.IUserDao;
import com.j3cs.Telus.donations.domain.Authority;
import com.j3cs.Telus.donations.domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author juliocardona
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    IUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User appUser = userDao.findByEmail(email);

        //Mapear nuestra lista de Authority con la de spring security 
        List grantList = new ArrayList<GrantedAuthority>();
        for (Authority authority : appUser.getAuthorityList()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getRolName());
            grantList.add(grantedAuthority);
        }
    

    //UserDetails user = (UserDetails) );
    return new org.springframework.security.core.userdetails.User(appUser.getEmail(), appUser.getPassword(), grantList) ;
}

}
