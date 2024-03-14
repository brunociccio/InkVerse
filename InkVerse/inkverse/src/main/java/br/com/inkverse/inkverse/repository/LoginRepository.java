package br.com.inkverse.inkverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.inkverse.inkverse.model.Login;

public interface LoginRepository extends JpaRepository<Login, String> {
    
}
