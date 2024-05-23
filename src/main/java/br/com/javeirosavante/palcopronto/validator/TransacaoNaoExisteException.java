package br.com.javeirosavante.palcopronto.validator;

public class TransacaoNaoExisteException extends RuntimeException {
    public TransacaoNaoExisteException(String msg) {
        super(msg);
    }
}
