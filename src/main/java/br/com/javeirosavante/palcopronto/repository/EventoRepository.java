package br.com.javeirosavante.palcopronto.repository;


import br.com.javeirosavante.palcopronto.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

    public Optional<Evento> findById(@Param("idEvento") Long idEvento);

    public Optional<Evento> findEventoByNomeEventoContainingIgnoreCase(@Param("nomeEvento") String nomeEvento);

    @Query(value = "SELECT e FROM Evento e WHERE e.espaco.idEspaco = :id")
    public List<Evento> findAllByIdEspaco(@Param("id") Long id);
}
