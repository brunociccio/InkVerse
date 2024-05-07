package br.com.inkverse.inkverse.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.com.inkverse.inkverse.model.Cadastro;
import br.com.inkverse.inkverse.repository.CadastroRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("cadastro")
@Slf4j
@CacheConfig(cacheNames = "cadastros")
@Tag(name = "cadastros")
public class CadastroController {

    @Autowired
    CadastroRepository repository;

    @GetMapping()
    @Cacheable
    @Operation(
        summary = "Cadastro",
        description = "Endpoints relacionados a cadastro"
    )
    public List<Cadastro> index() {
        return repository.findAll();
    }

    // POST
    @PostMapping
    @ResponseStatus(CREATED)
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Cadastro criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Validação falhou. Verifique o corpo da requisição")
    })
    @CacheEvict(allEntries = true)
    public Cadastro create(@Valid @RequestBody Cadastro cadastro) {
        log.info("Criando cadastro: {}", cadastro);
        return repository.save(cadastro);
    }

    // GET
    @GetMapping("{id}")
    public ResponseEntity<Cadastro> show(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT
    @PutMapping("{id}")
    @CacheEvict(allEntries = true)
    public Cadastro update(@PathVariable Long id, @Valid @RequestBody Cadastro cadastro) {
        log.info("Atualizando cadastro {} para {}", id, cadastro);
        return repository.findById(id)
                .map(existingCadastro -> {
                    cadastro.setIdCadastrar(existingCadastro.getIdCadastrar());
                    return repository.save(cadastro);
                })
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Cadastro não encontrado"));
    }

    // DELETE
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    @CacheEvict(allEntries = true)
    public void destroy(@PathVariable Long id) {
        log.info("Apagando cadastro: {}", id);
        repository.deleteById(id);
    }
}

