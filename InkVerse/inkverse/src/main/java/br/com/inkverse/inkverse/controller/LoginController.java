package br.com.inkverse.inkverse.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.inkverse.inkverse.model.Login;
import br.com.inkverse.inkverse.repository.LoginRepository;
import br.com.inkverse.inkverse.validation.TipoLogin;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@PutMapping("{id}")
public Login update(@PathVariable String id, @RequestBody Login login) {
    log.info("atualizando login {} para {}", id, login);

    verificarSeLoginExiste(id);
    login.setId(Long.valueOf(id));
    return repository.save(login);
}

// DELETE
@DeleteMapping("{id}")
@ResponseStatus(NO_CONTENT)
public void destroy(@PathVariable String id) {
    log.info("apagando login {}", id);

    verificarSeLoginExiste(id);
    repository.deleteById(id);
}

// TESTE DE IMPLEMENTAÇÃO DE METODOS PARA MENSAGENS DE VALIDAÇÃO
    @TipoLogin(message = "{login.tipo.message}")
    private String tipo;

    @NotBlank(message = "{login.descricao.notblank}")
    private String descricao;

//
private void verificarSeLoginExiste(String id) {
    repository
            .findById(id)
            .orElseThrow(
                    () -> new ResponseStatusException(
                            NOT_FOUND,
                            "Não existe login com o id informado"));
}
}
