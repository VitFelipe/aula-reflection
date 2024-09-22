package org.exemplo.refl;

import org.example.refl.TransformModel;
import org.example.repository.entity.Endereco;
import org.example.repository.entity.Pessoa;
import org.example.repository.entity.PessoaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TransformTest {
    final TransformModel transformModel = new TransformModel();

    @Test
    public void shouldTransform() throws ClassNotFoundException {
        Pessoa pessoa = PessoaFixture.buildPessoa();
        PessoaDTO pessoaDTO = transformModel.transform(pessoa);
        Assertions.assertInstanceOf(PessoaDTO.class,pessoaDTO);
        Assertions.assertAll("Deve Transformar o objeto pessoa para o objeto PessoaDTO",
                ()->{Assertions.assertEquals(pessoa.getNome(),pessoaDTO.getNome());},
                ()->{Assertions.assertEquals(pessoa.getEmail(),pessoaDTO.getEmail());
        });
    }

    @Test
    public  void shouldFailTransform(){
        Endereco endereco =  new Endereco(1,"Rua 2 ","Angelim");
        Assertions.assertThrows(ClassNotFoundException.class,()->{
           transformModel.transform(endereco);
        });
    }


    @Test
    public void shouldTransformWhereSomeFieldEmailIsNull() throws ClassNotFoundException{
        Pessoa pessoaSemEmail = PessoaFixture.buildPessoaSemEmail();
        PessoaDTO pessoaDTOSemEmail = transformModel.transform(pessoaSemEmail);
        Assertions.assertEquals(null,pessoaDTOSemEmail.getEmail());
    }


}
