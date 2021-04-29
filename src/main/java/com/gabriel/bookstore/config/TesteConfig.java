package com.gabriel.bookstore.config;

import com.gabriel.bookstore.services.Dbsarvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TesteConfig {

    @Autowired
    private Dbsarvice dbsarvice;

    @Bean // vai subir sempre que tiver ativo
    public void instanciaBaseDeDados () {
        this.dbsarvice.instanciaBaseDeDados();
    }
}
