package br.com.javeirosavante.palcopronto.service;

import br.com.javeirosavante.palcopronto.model.Ingresso;
import br.com.javeirosavante.palcopronto.repository.IngressoRepository;
import br.com.javeirosavante.palcopronto.validator.IngressoJaExistenteException;
import br.com.javeirosavante.palcopronto.validator.IngressoNaoExistenteException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngressoServiceImpl implements IngressoService{

    @Autowired
    private IngressoRepository repository;

    @Override
    public List<Ingresso> todosIngressos() {
        return repository.findAll();
    }

    @Override
    public Ingresso criarIngresso(Ingresso ingresso) {
        if (repository.findById(ingresso.getIdIngresso()).isPresent())
            throw new IngressoJaExistenteException("Ingresso já cadastrado");

        return repository.save(ingresso);
    }

    @Override
    public void deletarIngresso(Long idIngresso) {
        final Optional<Ingresso> ingressoOptional = repository.findById(idIngresso);
        if (ingressoOptional.isPresent())
            repository.deleteById(idIngresso);

        throw new IngressoNaoExistenteException("O ingresso não existe");
    }

    @Override
    public List<Ingresso> getIngressoByEvento(Long idEvento) {
        return repository.findByEventoIdEvento(idEvento);
    }

    @Override
    public int vendaIngresso(Long idIngresso) {
        final var ingressoProcurado = repository.findById(idIngresso);
        ingressoProcurado.ifPresent(ingresso -> ingresso.setQuantidadeMaxima(ingresso.getQuantidadeMaxima() - 1));
        return ingressoProcurado.get().getQuantidadeMaxima();
    }
}
