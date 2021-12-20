package com.ciclo4.reto5;

import com.ciclo4.reto5.repository.crud.GadgetCrudRepository;
import com.ciclo4.reto5.repository.crud.OrderCrudRepository;
import com.ciclo4.reto5.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Reto5Application implements CommandLineRunner{
    
    @Autowired
    private UserCrudRepository userCrudRepository;
    
    @Autowired
    private GadgetCrudRepository gadgetCrudRepository;
    
    @Autowired
    private OrderCrudRepository orderCrudRepository;
    
    
	public static void main(String[] args) {
		SpringApplication.run(Reto5Application.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        userCrudRepository.deleteAll();
        gadgetCrudRepository.deleteAll();
        orderCrudRepository.deleteAll();
    }

}
