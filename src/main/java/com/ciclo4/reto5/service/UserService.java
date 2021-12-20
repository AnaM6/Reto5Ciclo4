package com.ciclo4.reto5.service;

import com.ciclo4.reto5.model.User;
import com.ciclo4.reto5.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gonza
 */
@Service
public class UserService {
    
    /**
     * 
     */
    @Autowired
    private UserRepository userRepository;
    
    /**
     * 
     * @return 
     */
    public List<User> getAll() {
        return userRepository.getAll();
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public Optional<User> getUsuario(int id) {
        return userRepository.getUsuario(id);
    }
    
    /**
     * 
     * @param user
     * @return 
     */
    public User create(User user) {
        Optional<User> idMaximo = userRepository.getIdMaximo();
        if (user.getId()==null){
            if(idMaximo.isPresent()){
                user.setId(idMaximo.get().getId()+1);
            }else{
                user.setId(1);
            }
        }
        
        if (user.getId() == null) {
            return user;
        } else {
            Optional<User> dbUser = userRepository.getUsuario(user.getId());
            if (dbUser.isEmpty()) {
                if (getByEmail(user.getEmail()) == false) {
                    return userRepository.create(user);
                } else {
                    return user;
                }
            } else {
                return user;
            }
        }
    }
    
    /**
     * 
     * @param user
     * @return 
     */
    public User update(User user){
        if(user.getId()!=null){
            Optional<User>userDb = userRepository.getUsuario(user.getId());
            if(!userDb.isEmpty()){
                if(user.getIdentification()!=null){
                    userDb.get().setIdentification(user.getIdentification());
                }
                if(user.getName()!=null){
                    userDb.get().setName(user.getName());
                }
                if(user.getBirthtDay() != null){
                    userDb.get().setBirthtDay(user.getBirthtDay());
                }
                if(user.getMonthBirthtDay() != null){
                    userDb.get().setMonthBirthtDay(user.getMonthBirthtDay());
                }
                if(user.getAddress()!=null){
                    userDb.get().setAddress(user.getAddress());
                }
                if(user.getCellPhone()!=null){
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if(user.getEmail()!=null){
                    userDb.get().setEmail(user.getEmail());
                }
                if(user.getPassword()!=null){
                    userDb.get().setPassword(user.getPassword());
                }
                if(user.getZone()!=null){
                    userDb.get().setZone(user.getZone());
                }
                if(user.getType()!=null){
                   userDb.get().setType(user.getType());
                }
                userRepository.create(userDb.get());
                return userDb.get();
            }else{
                return user;
            }
        }
        return user;
    }
    
    /**
     * 
     * @param userId
     * @return 
     */
    public boolean delete(int userId) {
        Boolean verificacion = getUsuario(userId).map(user ->{
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return verificacion;
    }
    
    /**
     * 
     * @param email
     * @return 
     */
    public boolean getByEmail(String email){
        Optional<User> verificarEmail = userRepository.getByEmail(email);
        
        return verificarEmail.isPresent();
    }
    
    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    public User getByEmailAndPassword(String email, String password){
        Optional<User> user = userRepository.getByEmalAndPassword(email, password);
        if(user.isEmpty()){
            return new User();
        }
        return user.get();
    }
    
    public List<User> getByMothBirthday(String mesCumpleaños){
        
        return userRepository.getMothBirthday(mesCumpleaños);
    }
}