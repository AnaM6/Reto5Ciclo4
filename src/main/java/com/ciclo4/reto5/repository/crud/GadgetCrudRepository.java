/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo4.reto5.repository.crud;

import com.ciclo4.reto5.model.Gadget;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author gonza
 */
public interface GadgetCrudRepository extends MongoRepository<Gadget, Integer>{
    
    @Query("{ 'price' : { '$lte' : ?0}}")
    public List<Gadget> findByPrecio(double precio);
    
    @Query("{ 'description' : { '$regex' : { '$regularExpression' : { 'pattern' : '?0', 'options' : 'i'}}}}")
    public List<Gadget> findByDescription(final String description);
}
