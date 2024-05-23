package br.com.javeirosavante.palcopronto.repository;

import br.com.javeirosavante.palcopronto.model.Ingresso;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class IngressoRepositoryTest {
    @Mock
    private IngressoRepository ingressoRepository;

    @Test
    public void testFindByEventoIdEvento() {
        Long idEvento = 1L;
        List<Ingresso> ingressos = List.of(new Ingresso(), new Ingresso());
        when(ingressoRepository.findByEventoIdEvento(idEvento)).thenReturn(ingressos);
        List<Ingresso> result = ingressoRepository.findByEventoIdEvento(idEvento);
        verify(ingressoRepository, times(1)).findByEventoIdEvento(idEvento);
        assert (result.size() == 2);
    }
}

