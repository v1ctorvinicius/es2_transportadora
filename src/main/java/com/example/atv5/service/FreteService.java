package com.example.atv5.service;

import com.example.atv5.model.frete.CalculadoraDePrecoFrete;
import com.example.atv5.model.frete.Frete;
import com.example.atv5.repository.CidadeRepository;
import com.example.atv5.repository.FreteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FreteService {

    private final FreteRepository repository;
    private final CidadeRepository cidadeRepository;

    public Frete cadastraFrete(Frete frete) {
        return repository.save(frete);
    }

    public Float calcularPrecoDoFrete(Long freteId) {
        CalculadoraDePrecoFrete calculadoraDePrecoFrete = new CalculadoraDePrecoFrete(repository, cidadeRepository);
        return calculadoraDePrecoFrete.calcularPrecoFrete(freteId);

    }

    public Frete buscaFreteDeMaiorValor(){
        return repository.findFreteDeMaiorValor();
    }

    public List<Frete> listarFretes() {
        return repository.findAll();
    }

    public List<Frete> recuperaFretesPorClienteOrdenadoPorValor(Long id) {
        return repository.findAllByClienteIdOrderByValorAsc(id);
    }
}
