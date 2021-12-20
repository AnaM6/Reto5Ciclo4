/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo4.reto5.repository.crud;

import com.ciclo4.reto5.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author gonza
 */
public interface UserCrudRepository extends MongoRepository<User,Integer>{
    
    Optional<User> findByEmail(String email);
    //List<User> findBybirthDay(Date date);
    Optional<User> findByEmailAndPassword(String email, String password);
   // Optional<User> findByNameOrEmail(String name, String email);
    Optional<User> findTopByOrderByIdDesc();
    
    List<User> findByMonthBirthtDay(String mesCumpleños);
}
