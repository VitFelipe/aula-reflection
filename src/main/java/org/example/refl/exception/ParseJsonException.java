package org.example.refl.exception;

public class ParseJsonException extends Exception {
    public ParseJsonException(String descricaoErro, Throwable e){
        super(descricaoErro,e);
    }
}
