package org.exemplo.refl;

import org.example.repository.entity.Pessoa;

import java.time.LocalDate;

public  class PessoaFixture {


    public static Pessoa buildPessoa(){
        return new Pessoa(1, "vitor@gmail.com", LocalDate.now(), "Vitor Pinto");
    }

    public static  Pessoa buildPessoaSemEmail(){
        return new Pessoa("Vitor Pinto");
    }

}
