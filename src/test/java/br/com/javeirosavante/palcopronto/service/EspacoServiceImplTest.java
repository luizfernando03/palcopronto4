package br.com.javeirosavante.palcopronto.service;

import br.com.javeirosavante.palcopronto.model.Espaco;
import br.com.javeirosavante.palcopronto.repository.EspacoRepository;
import br.com.javeirosavante.palcopronto.validator.EspacoExistenteException;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;



import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class EspacoServiceImplTest {

    @InjectMocks private EspacoServiceImpl espacoService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCriarEspacoComEspacoExistenteDeveLancarExcecao() {
        Espaco espacoExistente = Espaco.builder().idEspaco(1L).build();

        Espaco espacoDto = Espaco.builder().idEspaco(1L).build();


        EspacoRepository repositoryMock = mock(EspacoRepository.class);
        when(repositoryMock.findById(espacoDto.getIdEspaco())).thenReturn(Optional.of(espacoExistente));

        EspacoServiceImpl espacoService = new EspacoServiceImpl(repositoryMock);

        EspacoExistenteException excecao = assertThrows(EspacoExistenteException.class, () -> {
            espacoService.criarEspaco(espacoDto);
        });

        String mensagemEsperada = "Espaço já cadastrado";
        String mensagemRecebida = excecao.getMessage();
        assertEquals(mensagemEsperada, mensagemRecebida);
    }

    @Test
    public void criarEspacoOkTest(){
        Espaco espacoExistente = Espaco.builder().idEspaco(0L).build();

        Espaco espacoDto = Espaco.builder().idEspaco(1L).build();

        EspacoRepository repositoryMock = mock(EspacoRepository.class);
        when(repositoryMock.findById(espacoDto.getIdEspaco())).thenReturn((Optional.empty()));

        EspacoServiceImpl espacoService = new EspacoServiceImpl(repositoryMock);
        espacoService.criarEspaco(espacoDto);

        assertNotNull(espacoService);
    }
}
