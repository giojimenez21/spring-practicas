package com.citas.citas.models.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.citas.citas.models.dao.IUserDao;
import com.citas.citas.models.service.IUserDbService;

@Service
public class UserServiceImpl implements IUserDbService{
    @Autowired
    private IUserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }
    
}
