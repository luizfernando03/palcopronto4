package br.com.javeirosavante.palcopronto.repository;

import br.com.javeirosavante.palcopronto.dto.TipoIngresso;
import br.com.javeirosavante.palcopronto.model.Ingresso;
import br.com.javeirosavante.palcopronto.model.Espaco;
import br.com.javeirosavante.palcopronto.model.Evento;
import br.com.javeirosavante.palcopronto.model.Transacao;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class DataIngestion implements CommandLineRunner {

    private final EspacoRepository espacoRepository;
    private final EventoRepository eventoRepository;
    private final IngressoRepository ingressoRepository;
    private final TransacaoRepository transacaoRepository;

    @Override
    public void run(String... args) throws Exception {
        Espaco espaco1 = Espaco.builder()
                .descricao("ESPAÇO A")
                .capacidadeMaxima(500)
                .disponibilidade(true)
                .build();

        Espaco espaco2 = Espaco.builder()
                .descricao("ESPAÇO B")
                .capacidadeMaxima(250)
                .disponibilidade(true)
                .build();

        Evento evento1 = Evento.builder()
                .nomeEvento("EVENTO A")
                .descricaoEvento("a")
                .dataHoraEvento(LocalDateTime.now())
                .espaco(espaco1)
                .build();

        Evento evento2 = Evento.builder()
                .nomeEvento("EVENTO B")
                .descricaoEvento("a")
                .dataHoraEvento(LocalDateTime.now())
                .espaco(espaco2)
                .build();

        Ingresso ingresso1 = Ingresso.builder()
                .precoIngresso(100.00)
                .tipoIngresso(TipoIngresso.VIP)
                .ingressoDisponivel(true)
                .build();

        Transacao transacao1 = Transacao.builder()
                .evento(evento1)
                .ingresso(ingresso1)
                .dataTransacao(LocalDateTime.now())
                .build();


        espacoRepository.save(espaco1);
        espacoRepository.save(espaco2);

        eventoRepository.save(evento1);
        eventoRepository.save(evento2);

        ingressoRepository.save(ingresso1);

        transacaoRepository.save(transacao1);
    }
}

