package br.com.javeirosavante.palcopronto.dto;

import br.com.javeirosavante.palcopronto.model.Evento;
import br.com.javeirosavante.palcopronto.model.Ingresso;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TransacaoDto {

    private Long idTransacao;

    private LocalDateTime dataTransacao;

    private Evento evento;

    private Ingresso ingresso;
}
