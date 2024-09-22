package org.example;

import org.example.refl.TransformModel;
import org.example.repository.entity.Pessoa;
import org.example.repository.entity.PessoaDTO;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            Pessoa pessoa = new Pessoa(1, "vito@gmail.com", LocalDate.now(), "Vitor");
            TransformModel transformModel = new TransformModel();
            PessoaDTO pessoaDTO = (PessoaDTO) transformModel.transform(pessoa);
            System.out.println(pessoaDTO);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}