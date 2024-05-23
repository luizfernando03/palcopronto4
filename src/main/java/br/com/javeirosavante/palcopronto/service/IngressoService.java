package br.com.javeirosavante.palcopronto.service;

import br.com.javeirosavante.palcopronto.model.Ingresso;

import java.util.List;

public interface IngressoService {

    List<Ingresso> todosIngressos();

    Ingresso criarIngresso(Ingresso ingresso);

    void deletarIngresso(Long idIngresso);

    List<Ingresso> getIngressoByEvento(Long idEvento);

    int vendaIngresso(Long idIngresso);
}
