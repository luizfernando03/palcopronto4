package br.com.javeirosavante.palcopronto.controller;

import br.com.javeirosavante.palcopronto.dto.EventoDto;
import br.com.javeirosavante.palcopronto.model.Evento;
import br.com.javeirosavante.palcopronto.service.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static br.com.javeirosavante.palcopronto.mapper.EventoMapper.toDto;
import static br.com.javeirosavante.palcopronto.mapper.EventoMapper.toEntity;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento> getAllEventos() {
        return eventoService.findAll();
    }

    @GetMapping("/{idEvento}")
    public ResponseEntity<Evento> getEventoById(@PathVariable Long idEvento) {
        Optional<Evento> evento = eventoService.findById(idEvento);

        return evento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/listarevento/{idEspaco}")
    public ResponseEntity<List<Evento>> findAllEventoByEspaco(@PathVariable Long idEspaco) {

        return ResponseEntity.ok(eventoService.findAllEventoByEspaco(idEspaco));
    }

    @PostMapping
    public ResponseEntity<Void> criarEvento(@RequestBody @Valid EventoDto dto) {
        eventoService.criarEvento(toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/atualizar/{idEvento}")
    public ResponseEntity<EventoDto> updateEvento(@PathVariable("idEvento") final Long idEvento,
                                           @RequestBody @Valid final EventoDto dto) {

        final var evento = eventoService.findById(idEvento);
        if (evento.isPresent()) {
            eventoService.atualizarEvento(idEvento, toEntity(dto));
            return ResponseEntity.ok(toDto(evento.get()));
        }
        else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/{idEvento}")
    public ResponseEntity<Void> deleteEvento(@PathVariable Long idEvento) {
        try {
        eventoService.deletarEvento(idEvento); return ResponseEntity.noContent().build();
    } catch (Exception e) {
        return ResponseEntity.notFound().build();
    }
    }
}

