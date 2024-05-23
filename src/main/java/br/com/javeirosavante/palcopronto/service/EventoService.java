package br.com.javeirosavante.palcopronto.service;

import br.com.javeirosavante.palcopronto.model.Evento;

import java.util.List;
import java.util.Optional;

public interface EventoService {

    List<Evento> findAll();

    Optional<Evento> findById(final Long idEvento);

    List<Evento> findAllEventoByEspaco(Long idEspaco);

    Optional<Evento> findEventoByNameEventoContainingIgnoreCase(final String nomeEvento);

    Evento criarEvento(final Evento eventoDto);

    Optional<Evento> atualizarEvento(final Long idEvento, final Evento eventoAtualizado);

    void deletarEvento(final Long idEvento);
}
