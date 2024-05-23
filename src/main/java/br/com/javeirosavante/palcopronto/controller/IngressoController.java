package br.com.javeirosavante.palcopronto.controller;

import br.com.javeirosavante.palcopronto.model.Ingresso;
import br.com.javeirosavante.palcopronto.service.IngressoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ingresso")
public class IngressoController {

    @Autowired
    private IngressoService service;

    @GetMapping
    public List<Ingresso> todosIngressos() {
        return service.todosIngressos();
    }

    @GetMapping("/evento/{idEvento}")
    public List<Ingresso> getIngressoByIdEvento(@PathVariable Long idEvento) {
        return service.getIngressoByEvento(idEvento);
    }
}
