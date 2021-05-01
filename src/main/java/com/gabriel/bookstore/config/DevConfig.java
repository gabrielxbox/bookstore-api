package com.gabriel.bookstore.config;

import com.gabriel.bookstore.services.Dbsarvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev") // para ficar visivel para  application-dev.properties
public class DevConfig {

    @Autowired
    private Dbsarvice dbsarvice;

    @Value("${spring.jpa.hibernate.ddl-auto}") // pega o caminho para ver o valor
    private String strategy;

    @Bean // para iniciar assim que a class  for chamada
    public  boolean instanciaBaseDeDados() {
        if(this.strategy.equals("create")){
            this.dbsarvice.instanciaBaseDeDados();
        }
        return false;
    }

}
