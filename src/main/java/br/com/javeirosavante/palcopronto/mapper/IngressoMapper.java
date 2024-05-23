package br.com.javeirosavante.palcopronto.mapper;

import br.com.javeirosavante.palcopronto.dto.IngressoDto;
import br.com.javeirosavante.palcopronto.model.Ingresso;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class IngressoMapper {

    public static List<IngressoDto> toDto(final List<Ingresso> entities) {
        return entities.stream()
                .map(entity -> toDto(entity))
                .collect(Collectors.toList());
    }

    public static IngressoDto toDto(final Ingresso entity) {
        if (Objects.nonNull(entity)) {
            return IngressoDto.builder()
                    .idIngresso(entity.getIdIngresso())
                    .tipoIngresso(entity.getTipoIngresso())
                    .ingressoDisponivel(entity.getIngressoDisponivel())
                    .precoIngresso(entity.getPrecoIngresso())
                    .evento(entity.getEvento())
                    .build();
        } else {
            return IngressoDto.builder().build();
        }
    }

    public static Ingresso toEntity(final IngressoDto dto) {
        if (Objects.nonNull(dto)) {
            return Ingresso.builder()
                    .idIngresso(dto.getIdIngresso())
                    .tipoIngresso(dto.getTipoIngresso())
                    .ingressoDisponivel(dto.getIngressoDisponivel())
                    .precoIngresso(dto.getPrecoIngresso())
                    .evento(dto.getEvento())
                    .build();
        } else {
            return Ingresso.builder().build();
        }
    }

    public static void copy(final Ingresso source, final Ingresso destiny) {
        destiny.setIdIngresso(source.getIdIngresso());
        destiny.setTipoIngresso(source.getTipoIngresso());
        destiny.setIngressoDisponivel(source.getIngressoDisponivel());
        destiny.setPrecoIngresso(source.getPrecoIngresso());
        destiny.setEvento(source.getEvento());
    }
}