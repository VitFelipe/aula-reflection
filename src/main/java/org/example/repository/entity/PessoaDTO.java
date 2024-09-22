package org.example.repository.entity;


public class PessoaDTO {

    public PessoaDTO() {

    }


    public PessoaDTO(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    private String nome;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PessoaDTO{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
