/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo4.reto5.repository;

import com.ciclo4.reto5.model.Gadget;
import com.ciclo4.reto5.repository.crud.GadgetCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gonza
 */
@Repository
public class GadgetRepository {
    
    @Autowired
    private GadgetCrudRepository gadgetCrudRepository;
    
    public List<Gadget> getAll(){
        return gadgetCrudRepository.findAll();
    }
    
    public Optional<Gadget> getGadget(int id){
        return gadgetCrudRepository.findById(id);
    }
    
    public Gadget create(Gadget producto){
        return gadgetCrudRepository.save(producto);
    }
    
    public Gadget update(Gadget producto){
        return gadgetCrudRepository.save(producto);
    }
    
    public void delete (Gadget producto){
        gadgetCrudRepository.delete(producto);
    }
    
    public List<Gadget> getByPrice(double precio){
        return gadgetCrudRepository.findByPrecio(precio);
    }
    
    public List<Gadget> getByDescription(String description){
        return gadgetCrudRepository.findByDescription(description);
    }
}
