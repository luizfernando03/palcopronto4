package br.com.javeirosavante.palcopronto.mapper;

import br.com.javeirosavante.palcopronto.dto.EspacoDto;
import br.com.javeirosavante.palcopronto.model.Espaco;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EspacoMapper {

    public static List<EspacoDto> toDto(final List<Espaco> entities) {
        return entities.stream()
                .map(entity -> toDto(entity))
                .collect(Collectors.toList());
    }

    public static EspacoDto toDto(final Espaco entity) {
        if (Objects.nonNull(entity)) {
            return EspacoDto.builder()
                    .idEspaco(entity.getIdEspaco())
                    .descricao(entity.getDescricao())
                    .capacidadeMaxima(entity.getCapacidadeMaxima())
                    .disponibilidade(entity.getDisponibilidade())
                    .build();
        } else {
            return EspacoDto.builder().build();
        }
    }

    public static Espaco toEntity(final EspacoDto dto) {
        if (Objects.nonNull(dto)) {
            return Espaco.builder()
                    .idEspaco(dto.getIdEspaco())
                    .descricao(dto.getDescricao())
                    .capacidadeMaxima(dto.getCapacidadeMaxima())
                    .disponibilidade(dto.getDisponibilidade())
                    .build();
        } else {
            return Espaco.builder().build();
        }
    }

    public static Espaco copy(final Espaco source, final Espaco destiny) {
        return Espaco.builder()
                .idEspaco(source.getIdEspaco())
                .descricao(destiny.getDescricao())
                .capacidadeMaxima(destiny.getCapacidadeMaxima())
                .disponibilidade(destiny.getDisponibilidade())
                .eventos(source.getEventos())
                .build();
    }
}
