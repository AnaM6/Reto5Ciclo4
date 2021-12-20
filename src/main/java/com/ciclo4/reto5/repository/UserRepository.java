package com.ciclo4.reto5.repository;

import com.ciclo4.reto5.model.User;
import com.ciclo4.reto5.repository.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gonza
 */
@Repository
public class UserRepository {
    
    @Autowired
    private UserCrudRepository userCrudRepository;
    
    
    public List<User> getAll(){
        return userCrudRepository.findAll();
    }
    
    public Optional<User> getUsuario(int id){
        return userCrudRepository.findById(id);
    }
    
    public User create(User usuario){
        return userCrudRepository.save(usuario);
    }
    
    public User update(User usuario){
        return userCrudRepository.save(usuario);
    }
    
    public void delete(User usuario){
        userCrudRepository.delete(usuario);
    } 
    
    public Optional<User> getByEmail(String email){
        return userCrudRepository.findByEmail(email);
    }
    
    public Optional<User> getByEmalAndPassword(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    
    public Optional<User> getIdMaximo(){
        return userCrudRepository.findTopByOrderByIdDesc();
    }
    
    public List<User> getMothBirthday(String mesCumpleaños){
        return userCrudRepository.findByMonthBirthtDay(mesCumpleaños);
    }
}