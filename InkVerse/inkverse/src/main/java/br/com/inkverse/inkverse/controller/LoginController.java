package br.com.inkverse.inkverse.controller;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.inkverse.inkverse.model.Login;
import br.com.inkverse.inkverse.repository.LoginRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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

    // POST
    @PostMapping
    @ResponseStatus(CREATED)
    public Login create(@RequestBody Login login){
        log.info("cadastrando usuário {}", login);
        return repository.save(login);
    }

    // GET
    @GetMapping("{id}")
    public ResponseEntity<Login> show(@PathVariable String id){
        log.info("buscando login com id {}", id);

        return repository
                    .findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }
    
    // PUT


    // DELETE

}
