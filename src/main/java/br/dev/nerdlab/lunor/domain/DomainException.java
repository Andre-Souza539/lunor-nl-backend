package br.dev.nerdlab.lunor.domain;

public class DomainException extends RuntimeException {

    //Método Genérico para lançar exceções de domínio
    public DomainException(String message) {
        super(message);
    }
    
}
