package br.com.javeirosavante.palcopronto.model;

import br.com.javeirosavante.palcopronto.dto.TipoIngresso;
import br.com.javeirosavante.palcopronto.validator.IngressoEsgotadoException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Entity
@Table(name = "ingresso")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ingresso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIngresso;

    private TipoIngresso tipoIngresso;

    private Boolean ingressoDisponivel;

    private Double precoIngresso;

    private Integer quantidadeMaxima;

    @ManyToOne
    private Evento evento;

    @ManyToOne
    private Transacao transacao;
}