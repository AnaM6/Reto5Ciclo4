/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo4.reto5.web;

import com.ciclo4.reto5.model.Gadget;
import com.ciclo4.reto5.service.GadgetService;
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
@RequestMapping("/api/gadget")
@CrossOrigin("*")
public class GadgetController {
    
    @Autowired
    private GadgetService gadgetService;
    
    @GetMapping("/all")
    public List<Gadget> getGadgets(){
        return gadgetService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Gadget> getGadget(@PathVariable("id") int id){
        return gadgetService.getGadget(id);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget create(@RequestBody Gadget producto){
        return gadgetService.create(producto);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget update(@RequestBody Gadget producto){
        return gadgetService.update(producto);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return gadgetService.delete(id);
    }
    
    @GetMapping("/price/{precio}")
    public List<Gadget> getPrecio(@PathVariable("precio") double precio){
        return gadgetService.getByPrice(precio);
    }
    
    @GetMapping("/description/{descripcion}")
    public List<Gadget> getDescripcion(@PathVariable("descripcion") String descripcion){
        return gadgetService.getByDescription(descripcion);
    }
}
