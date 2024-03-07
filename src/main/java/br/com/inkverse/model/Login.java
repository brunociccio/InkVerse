package main.java.br.com.inkverse.model;

import java.util.Random;

public record Login(String nome, String email, String senha) {

    public Login(String nome, String email, String senha) {
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    }
}
