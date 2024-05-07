package br.com.inkverse.inkverse.config;

import org.springframework.boot.CommandLineRunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.inkverse.inkverse.repository.*;

@Configuration
public class DataBaseSeeder implements CommandLineRunner {

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    CadastroRepository cadastroRepository;

    @Override
    public void run(String... args) throws Exception {
        
    }

    
}
