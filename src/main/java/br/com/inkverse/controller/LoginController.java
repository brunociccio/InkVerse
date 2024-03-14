package br.com.inkverse.controller;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.inkverse.model.Login;
import br.com.inkverse.repository.LoginRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("login")
@Slf4j
public class LoginController {

    @Autowired
    LoginRepository repository;

    @GetMapping()    
    public List<Login> index() {
        return repository.findAll();
    }

/*@PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public Login create(@RequestBody Login login) {
        log.info("criação de novo usuário {}", login);
        repository.add(login);
        return login;
    }*/
}