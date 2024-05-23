package br.com.javeirosavante.palcopronto.validator;

public class IngressoNaoExistenteException extends RuntimeException {
    public IngressoNaoExistenteException(String msg) {
        super(msg);
    }
}
