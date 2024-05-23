package br.com.javeirosavante.palcopronto.service;

import br.com.javeirosavante.palcopronto.model.Espaco;
import br.com.javeirosavante.palcopronto.model.Evento;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface EspacoService {

    List<Espaco> findAll();

    Optional<Espaco> findById(final Long idEspaco);

  //  Optional<Espaco> findEventoByNameEventoContainingIgnoreCase(final String nomeEspaco);

    Espaco criarEspaco(final Espaco espacoDto);

    Optional<Espaco> atualizarEspaco(final Long idEspaco, final Espaco espacoAtualizado);

    void deletarEspaco(final Long idEspaco);

}

