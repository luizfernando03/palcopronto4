package br.com.javeirosavante.palcopronto.validator;

public class TransacaoExistenteException extends RuntimeException {
    public TransacaoExistenteException(String msg) {
        super(msg);
    }
}
