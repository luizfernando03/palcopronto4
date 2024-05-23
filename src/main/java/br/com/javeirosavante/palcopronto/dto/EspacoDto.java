package br.com.javeirosavante.palcopronto.dto;

import br.com.javeirosavante.palcopronto.model.Evento;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EspacoDto {

    @Id
    private Long idEspaco;

    private String descricao;

    private Integer capacidadeMaxima;

    private Boolean disponibilidade;

    private List<Evento> eventos;

}
