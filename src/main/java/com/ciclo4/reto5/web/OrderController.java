package com.ciclo4.reto5.web;

import com.ciclo4.reto5.model.Order;
import com.ciclo4.reto5.service.OrderService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gonza
 */
@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @GetMapping("/all")
    public List<Order> getOrdenes(){
        return orderService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Order> getOrden(@PathVariable("id")int id) {
        return orderService.getOrder(id);
    }
    
    //post
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order order){
        return orderService.create(order);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order){
        return orderService.update(order);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return orderService.delete(id);
    }
    
    @GetMapping("/zona/{zona}")
    public List<Order> getZona(@PathVariable("zona")String zona){
        return orderService.getByZone(zona);
    }
    
    @GetMapping("/status/{status}")
    public List<Order> getEstado(@PathVariable("status") String status){
        return orderService.getByStatus(status);
    }
    
    @GetMapping("/salesman/{id}")
    public List<Order> getOrderByUserId(@PathVariable("id") int id){
        return orderService.getByUserId(id);
    }
    
    @GetMapping("/state/{status}/{id}")
    public List<Order> getOrderByStatusAndUserId(@PathVariable("status") String status , @PathVariable("id") int id){
        return orderService.getByStatusAndUserId(status, id);
    }
    
    @GetMapping("/date/{date}/{id}")
    public List<Order> getOrderByDateAndUserId(@PathVariable("date") String date , @PathVariable("id") int id) {
        return orderService.getByDateAndUserId(date, id);
    }
    
    
}
