package br.com.javeirosavante.palcopronto.repository;


import br.com.javeirosavante.palcopronto.model.Espaco;
import br.com.javeirosavante.palcopronto.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EspacoRepository extends JpaRepository<Espaco, Long> {

    public List<Evento> findAllEventosByIdEspaco(@Param("idEspaco") Long idEspaco);
}