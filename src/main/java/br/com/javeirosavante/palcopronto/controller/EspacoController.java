package br.com.javeirosavante.palcopronto.controller;

import br.com.javeirosavante.palcopronto.dto.EspacoDto;
import br.com.javeirosavante.palcopronto.model.Espaco;
import br.com.javeirosavante.palcopronto.service.EspacoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static br.com.javeirosavante.palcopronto.mapper.EspacoMapper.toDto;
import static br.com.javeirosavante.palcopronto.mapper.EspacoMapper.toEntity;

@RestController
@RequestMapping("/espaco")
public class EspacoController {

    @Autowired
    private EspacoService espacoService;

    @GetMapping
    public List<Espaco> getAllEspacos() {
        return espacoService.findAll();
    }

    @GetMapping("/{idEspaco}")
    public ResponseEntity<Espaco> getEspacoById(@PathVariable Long idEspaco) {
        Optional<Espaco> espaco = espacoService.findById(idEspaco);

        return espaco.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createEspaco(@RequestBody @Valid EspacoDto dto) {
        espacoService.criarEspaco(toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/atualizar/{idEspaco}")
    public ResponseEntity<EspacoDto> updateEvento(@PathVariable("idEspaco") final Long idEspaco,
                                                  @RequestBody @Valid final EspacoDto dto) {

        final var espaco = espacoService.findById(idEspaco);
        if (espaco.isPresent()) {
            espacoService.atualizarEspaco(idEspaco, toEntity(dto));
            return ResponseEntity.ok(toDto(espaco.get()));
        }
        else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/{idEspaco}")
    public ResponseEntity<Void> deleteEspaco(@PathVariable Long idEspaco) {
        try {
            espacoService.deletarEspaco(idEspaco);
            return ResponseEntity.noContent().build();
    } catch (Exception e) {
        return ResponseEntity.notFound().build();
    }
    }
}

