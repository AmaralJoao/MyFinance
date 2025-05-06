package com.br.MyFinance.Exception;

public class EmailJaExistenteException extends RuntimeException{

    public EmailJaExistenteException(String message) {
        super(message);
    }
}
