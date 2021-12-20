/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo4.reto5.service;

import com.ciclo4.reto5.model.Gadget;
import com.ciclo4.reto5.repository.GadgetRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gonza
 */
@Service
public class GadgetService {
    @Autowired
    private GadgetRepository gadgetRepository;
    
    public List<Gadget> getAll(){
        return gadgetRepository.getAll();
    }
    
    public Optional<Gadget> getGadget(int id){
        return gadgetRepository.getGadget(id);
    }
    
    public Gadget create(Gadget producto){
        if(producto.getId() == null){
            return producto; 
        }
        else{
            Optional<Gadget> varTmp = gadgetRepository.getGadget(producto.getId());
            
            if(varTmp.isPresent()){
                return producto;
            }else{
                gadgetRepository.create(producto);
            }
        }
        
        return producto;
    }
    
    public Gadget update(Gadget producto){
        
        if(producto.getId() != null){
            Optional<Gadget> productoDb = gadgetRepository.getGadget(producto.getId());
            
            if(productoDb.isPresent()){
                
                if(producto.getBrand() != null){
                    productoDb.get().setBrand(producto.getBrand());
                }
                if(producto.getCategory() != null){
                    productoDb.get().setCategory(producto.getCategory());
                }
                if(producto.getName() != null){
                    productoDb.get().setName(producto.getName());
                }
                if(producto.getDescription() != null){
                    productoDb.get().setDescription(producto.getDescription());
                }
                if(producto.getPrice() != 0.0){
                    productoDb.get().setPrice(producto.getPrice());
                }
                if(producto.getQuantity() != 0){
                    productoDb.get().setQuantity(producto.getQuantity());
                }
                if(producto.getPhotography() != null){
                    productoDb.get().setPhotography(producto.getPhotography());
                }
                productoDb.get().setAvailability(producto.isAvailability());
                
                gadgetRepository.update(productoDb.get());
                
                return productoDb.get();
                
            }
            
            return producto;
        }
        
        return producto;
    }
    
    
    public boolean delete(int id){
        Boolean verificar = getGadget(id).map(producto -> {
            gadgetRepository.delete(producto);
            return true;
        }).orElse(false);
        
        return verificar;
    }
    
    public List<Gadget> getByPrice(double precio){
        return gadgetRepository.getByPrice(precio);
    }
    
    public List<Gadget> getByDescription(String descripcion){
        return gadgetRepository.getByDescription(descripcion);
    }
}


