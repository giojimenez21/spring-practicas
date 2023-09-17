package com.citas.citas.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.citas.citas.models.dao.IUserDao;
import com.citas.citas.security.service.IUserService;

@Service
public class UserDbServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) 
                throws UsernameNotFoundException {
                return userDao.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
            
        };
    }

}
