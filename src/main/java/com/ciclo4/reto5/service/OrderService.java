/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo4.reto5.service;

import com.ciclo4.reto5.model.Order;
import com.ciclo4.reto5.repository.OrderRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gonza
 */
@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    public List<Order> getAll(){
        return orderRepository.getAll();
    }
    
    //Traer dato individual
    public Optional<Order> getOrder(int id){
        return orderRepository.getOrder(id);
    }
    
    // Crear
    public Order create(Order order){
       Optional<Order> orderIdMax= orderRepository.getIdMaximo();
       if(order.getId()==null){
           if(orderIdMax.isEmpty()){
           order.setId(1);
           }else {
           order.setId(orderIdMax.get().getId()+1);
           }
       }
       Optional<Order> datos = orderRepository.getOrder(order.getId());
       if(datos.isEmpty()){
           return orderRepository.create(order);
       }else{
           return order;
       }
       
    }
    public Order update(Order order){
        if(order.getId()!=null){
            Optional<Order> orderDb = orderRepository.getOrder(order.getId());
            if(orderDb.isPresent()){
                if(order.getStatus() !=null){
                    orderDb.get().setStatus(order.getStatus());
                    
                }
                orderRepository.update(orderDb.get());
                return orderDb.get();
            }
            return order;
        }
        return order;
    }
    
    public boolean delete(int id){
        Boolean verificacion = getOrder(id).map(orden ->{
           orderRepository.delete(orden);
           return true;
        }).orElse(false);
        return verificacion;
    }
    
    public List<Order> getByZone(String zone){
        return orderRepository.getByZone(zone);
    }
    
    public List<Order> getByStatus(String status){
        return orderRepository.getByStatus(status);
    }
    
    public List<Order> getByUserId(int id){
        return orderRepository.getByUserId(id);
    }
    
    public List<Order> getByStatusAndUserId(String status , int id){
        return orderRepository.getByStatusAndUserId(status, id);
    }
    
    public List<Order> getByDateAndUserId(String date , int id) {
       try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = formato.parse(date);
            
            return orderRepository.getByDateAndUserId(fecha, id);
        } catch (ParseException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }  
    }
}
