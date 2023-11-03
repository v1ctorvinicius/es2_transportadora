package com.example.atv5.model.frete;

import com.example.atv5.model.Cidade;
import com.example.atv5.repository.CidadeRepository;
import com.example.atv5.repository.FreteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CalculadoraPrecoFrete {

    private final CidadeRepository cidadeRepository;

    private final Float PRECO_ATUAL_FRETE = 10.0f;

    public Float calcularPrecoFrete(Frete frete) {
        Optional<Cidade> cidade = cidadeRepository.findById(frete.getCidadeId());
        if (cidade.isPresent()) {

            return (PRECO_ATUAL_FRETE * frete.getValor() + cidade.get().getTaxa());
        }
        return null;
    }
}
