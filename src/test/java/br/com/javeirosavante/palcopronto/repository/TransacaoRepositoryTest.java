package br.com.javeirosavante.palcopronto.repository;

import br.com.javeirosavante.palcopronto.model.Transacao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransacaoRepositoryTest {
    @Mock
    private TransacaoRepository transacaoRepository;

    @Test
    public void testSaveTransacao() {
        Transacao transacao = new Transacao();

        when(transacaoRepository.save(transacao)).thenReturn(transacao);
        Transacao result = transacaoRepository.save(transacao);
        verify(transacaoRepository, times(1)).save(transacao);
        assert (result != null);
    }
}