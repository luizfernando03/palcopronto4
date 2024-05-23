package br.com.javeirosavante.palcopronto.validator;

public class IngressoEsgotadoException extends RuntimeException {
    public IngressoEsgotadoException(String msg) {
        super(msg);
    }
}
