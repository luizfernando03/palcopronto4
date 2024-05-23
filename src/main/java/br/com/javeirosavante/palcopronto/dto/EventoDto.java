package br.com.javeirosavante.palcopronto.dto;

import br.com.javeirosavante.palcopronto.model.Espaco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EventoDto {

    private Long idEvento;

    private String nomeEvento;

    private String descricaoEvento;

    private LocalDateTime dataHoraEvento;

    private Espaco espaco;

}
