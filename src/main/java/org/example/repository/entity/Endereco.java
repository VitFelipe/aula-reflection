package org.example.repository.entity;

public class Endereco {

    public Endereco(){

    }

    public Endereco(Integer enderecoId, String rua, String bairro ){
        this.enderecoId = enderecoId;
        this.rua = rua;
        this.bairro = bairro;
    }

    private Integer enderecoId;
    private String rua;
    private String bairro;

}
