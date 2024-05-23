package br.com.javeirosavante.palcopronto.service;

import br.com.javeirosavante.palcopronto.model.Transacao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface TransacaoService {

    List<Transacao> findAll();

    Optional<Transacao> findByIdTransacao(final Long idTransacao);


    Transacao criarTransacao(final Transacao transacaoDto);


    void cancelarTransacao(final Long idTransacao);

}
