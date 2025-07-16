/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tth.repositories;

import com.tth.pojo.User;
import java.util.List;

/**
 *
 * @author admin
 */
public interface UserRepository {
    User addUser(User user);
    User getUserByUsername(String username);
}
