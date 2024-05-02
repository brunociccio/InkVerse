package br.com.inkverse.inkverse.config;

import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.inkverse.inkverse.model.*;
import br.com.inkverse.inkverse.repository.*;

@Configuration
public class DataBaseSeeder implements CommandLineRunner {

    @Autowired
    LoginRepository loginRepository;

    @Override
    public void run(String... args) throws Exception {
        
    }

    
}
