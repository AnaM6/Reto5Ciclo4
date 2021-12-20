/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo4.reto5.repository;

import com.ciclo4.reto5.model.Order;
import com.ciclo4.reto5.repository.crud.OrderCrudRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gonza
 */
@Repository
public class OrderRepository {
    @Autowired
    private OrderCrudRepository orderCrudRepository;
    
    public List<Order> getAll(){
        return (List<Order>) orderCrudRepository.findAll();
    }
    
    public Optional<Order> getOrder(int id){
        return orderCrudRepository.findById(id);
    }
    
    //Crear
    public Order create(Order order){
        return orderCrudRepository.save(order);
    }
    
    public void update (Order order){
        orderCrudRepository.save(order);
    }
    
    public void delete (Order order){
        orderCrudRepository.delete(order);
    }
    
    public Optional<Order> getIdMaximo(){
        return orderCrudRepository.findTopByOrderByIdDesc();
    }
    
    //buscar por zona
    public List <Order>getByZone(String zona){
        return orderCrudRepository.findByZone(zona);
    }
    
    public List<Order> getByStatus(String status){
        return orderCrudRepository.findByStatus(status);
    }
    
    public List<Order> getByUserId(int id){
        return orderCrudRepository.findByUserId(id);
    }
    
    public List<Order> getByStatusAndUserId(String status , int id){
        return orderCrudRepository.findByStatusAndUserId(status, id);
    }
    
    public List<Order> getByDateAndUserId(Date date , int id){
        return orderCrudRepository.findByDateAndUserId(date, id);
    }
}
