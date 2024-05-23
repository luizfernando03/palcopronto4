package br.com.javeirosavante.palcopronto.repository;


import br.com.javeirosavante.palcopronto.model.Evento;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EspacoRepositoryTest {

    @Mock
    private EspacoRepository espacoRepository;

    @Test
    public void testFindAllEventosByIdEspaco() {
        Long idEspaco = 1L;
        List<Evento> eventos = List.of(new Evento(), new Evento());

        when(espacoRepository.findAllEventosByIdEspaco(idEspaco)).thenReturn(eventos);

        List<Evento> result = espacoRepository.findAllEventosByIdEspaco(idEspaco);

        verify(espacoRepository, times(1)).findAllEventosByIdEspaco(idEspaco);
        assert (result.size() == 2);
    }
}

