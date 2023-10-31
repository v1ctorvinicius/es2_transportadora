package com.example.atv5.model.frete;

import com.example.atv5.model.Cidade;
import com.example.atv5.repository.CidadeRepository;
import com.example.atv5.repository.FreteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CalculadoraDePrecoFrete {
    private final FreteRepository repository;
    private final CidadeRepository cidadeRepository;

    public Float calcularPrecoFrete(Long freteId) {
        Frete frete = repository.findById(freteId).orElse(null);
        if (frete == null) {
            return null;
        }
        var cidade = cidadeRepository.findById(frete.getCidadeId());
        if (cidade == null) {
            return null;
        }

        return (frete.getPRECO_ATUAL_FRETE() * frete.getValor()) + cidade.get().getTaxa();

    }
}
