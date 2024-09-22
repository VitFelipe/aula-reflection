package org.example.repository.entity;

import java.time.LocalDate;


public class Pessoa {
    public Pessoa() {

    }

    public Pessoa(Integer id, String email, LocalDate dataNascimento, String nome) {
        this.id = id;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.nome = nome;
    }

    public Pessoa(String nome){
        this.nome = nome;
    }

    private Integer id;
    private String email;
    private LocalDate dataNascimento;
    private String nome;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
