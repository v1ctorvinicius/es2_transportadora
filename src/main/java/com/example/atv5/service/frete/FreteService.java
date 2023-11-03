package com.example.atv5.service.frete;

import com.example.atv5.model.Cidade;
import com.example.atv5.model.frete.CalculadoraPrecoFrete;
import com.example.atv5.model.frete.Frete;
import com.example.atv5.repository.CidadeRepository;
import com.example.atv5.repository.ClienteRepository;
import com.example.atv5.repository.FreteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FreteService {

    private final FreteRepository freteRepository;
    private final CidadeRepository cidadeRepository;
    private final ClienteRepository clienteRepository;

    public List<Frete> listaFretes() {
        return freteRepository.findAll();
    }

    @Transactional
    public Frete cadastraFrete(Frete frete) {
        FreteValidator validator = new FreteValidator(cidadeRepository, clienteRepository);
        if(validator.isValid(frete)){
            return freteRepository.save(frete);
        }
        return null;
    }

    public Float calculaPrecoDoFrete(Frete frete) {
        CalculadoraPrecoFrete calculadoraPrecoFrete = new CalculadoraPrecoFrete(cidadeRepository);
        return calculadoraPrecoFrete.calcularPrecoFrete(frete);
    }

    public Frete recuperaFreteDeMaiorValor(){
        return freteRepository.findFreteDeMaiorValor();
    }

    public List<Frete> recuperaFretesPorClienteOrdenadoPorValor(Long id) {
        return freteRepository.findAllByClienteIdOrderByValorAsc(id);
    }


}
