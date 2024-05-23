package br.com.javeirosavante.palcopronto.repository;

import br.com.javeirosavante.palcopronto.model.Evento;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;
    @ExtendWith(MockitoExtension.class)
    public class EventoRepositoryTest {
        @Mock
        private EventoRepository eventoRepository;
        @Test
        public void testFindById() {
            Long idEvento = 1L;
            Evento evento = new Evento();
            when(eventoRepository.findById(idEvento)).thenReturn(Optional.of(evento));
            Optional<Evento> result = eventoRepository.findById(idEvento);
            verify(eventoRepository, times(1)).findById(idEvento);
            assert(result.isPresent());
        }
        @Test
        public void testFindAllByIdEspaco() {
            Long idEspaco = 1L;
            List<Evento> eventos = List.of(new Evento(), new Evento());
            when(eventoRepository.findAllByIdEspaco(idEspaco)).thenReturn(eventos);
            List<Evento> result = eventoRepository.findAllByIdEspaco(idEspaco);
            verify(eventoRepository, times(1)).findAllByIdEspaco(idEspaco);
            assert(result.size() == 2);
        }
    }


