package br.com.javeirosavante.palcopronto.mapper;

import br.com.javeirosavante.palcopronto.dto.TransacaoDto;
import br.com.javeirosavante.palcopronto.model.Transacao;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class TransacaoMapper {

    public static List<TransacaoDto> toDto(final List<Transacao> entities) {
        return entities.stream()
                .map (entity -> toDto(entity))
                .collect (Collectors.toList());
    }

    public static TransacaoDto toDto(final Transacao entity) {
        if (Objects.nonNull(entity)) {
            return TransacaoDto.builder()
                    .idTransacao(entity.getIdTransacao())
                    .dataTransacao(entity.getDataTransacao())
                    .evento(entity.getEvento())
                    .ingresso(entity.getIngresso())
                    .build();
        } else {
            return TransacaoDto.builder().build();
        }
    }

    public static Transacao toEntity(final TransacaoDto dto) {
        if (Objects.nonNull(dto)) {
            return Transacao.builder()
                    .idTransacao(dto.getIdTransacao())
                    .dataTransacao(dto.getDataTransacao())
                    .evento(dto.getEvento())
                    .ingresso(dto.getIngresso())
                    .build();
        } else {
            return Transacao.builder().build();
        }
    }
//
//    public static void copy(final Transacao source, final Transacao destiny) {
//        destiny.setIdIngresso(source.getIngresso());
//
//    }
}