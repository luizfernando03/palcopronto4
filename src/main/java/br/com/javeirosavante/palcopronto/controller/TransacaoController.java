package br.com.javeirosavante.palcopronto.controller;

import br.com.javeirosavante.palcopronto.dto.TransacaoDto;
import br.com.javeirosavante.palcopronto.model.Transacao;
import br.com.javeirosavante.palcopronto.service.IngressoService;
import br.com.javeirosavante.palcopronto.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static br.com.javeirosavante.palcopronto.mapper.TransacaoMapper.toEntity;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;
    private IngressoService ingressoService;

    @GetMapping
    public List<Transacao> getAllTransacoes() {
        return transacaoService.findAll();
    }

    @GetMapping("/{idTransacao}")
    public ResponseEntity<Transacao> getTransacaoByIdTransacao(@PathVariable Long idTransacao) {
        Optional<Transacao> transacao = transacaoService.findByIdTransacao(idTransacao);
        return transacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createTransacao(@RequestBody @Valid TransacaoDto transacao) {
        transacaoService.criarTransacao(toEntity(transacao));
        transacao.getIngresso().setQuantidadeMaxima(
                ingressoService.vendaIngresso(transacao.getIngresso().getIdIngresso()));

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @DeleteMapping("/{idTransacao}")
    public ResponseEntity<Void> deleteTransacao(@PathVariable Long idTransacao) {
        try {
        transacaoService.cancelarTransacao(idTransacao);
        return ResponseEntity.noContent().build();
    } catch (Exception e) {
        return ResponseEntity.notFound().build();
    }
    }
}

