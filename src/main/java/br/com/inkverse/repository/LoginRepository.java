package br.com.inkverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.inkverse.model.Login;

public interface LoginRepository extends JpaRepository<Login, String> {
    
}
