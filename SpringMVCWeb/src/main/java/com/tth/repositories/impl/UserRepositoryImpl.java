/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.repositories.impl;

import com.tth.pojo.User;
import com.tth.repositories.UserRepository;
import jakarta.persistence.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PC
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public User addUser(User user) {
        Session s = this.factory.getObject().getCurrentSession();
        s.persist(user);

        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("User.findByUsername", User.class);
        q.setParameter("username", username);

        return (User) q.getSingleResult();
    }

}
