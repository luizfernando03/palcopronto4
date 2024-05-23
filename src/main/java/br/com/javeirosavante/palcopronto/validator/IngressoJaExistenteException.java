package br.com.javeirosavante.palcopronto.validator;

public class IngressoJaExistenteException extends RuntimeException {
    public IngressoJaExistenteException(String msg) {
        super(msg);
    }
}
