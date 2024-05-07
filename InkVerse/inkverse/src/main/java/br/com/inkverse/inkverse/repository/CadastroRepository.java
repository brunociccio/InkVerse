package br.com.inkverse.inkverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.inkverse.inkverse.model.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {
    
}
