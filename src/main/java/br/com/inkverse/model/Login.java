package br.com.inkverse.model;

public record Login(String nome, String email, String senha) {

    public Login(String nome, String email, String senha) {
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    }
}
