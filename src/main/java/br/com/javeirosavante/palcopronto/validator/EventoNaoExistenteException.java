package br.com.javeirosavante.palcopronto.validator;

public class EventoNaoExistenteException extends RuntimeException {
    public EventoNaoExistenteException(String msg) {
        super(msg);
    }
}
