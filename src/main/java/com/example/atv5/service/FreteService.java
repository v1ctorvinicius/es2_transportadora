package com.example.atv5.service;

import com.example.atv5.model.Frete;
import com.example.atv5.repository.FreteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FreteService {

    private final FreteRepository repository;

    public Frete cadastrarFrete(Frete frete) {
        return repository.save(frete);
    }

    public Float calcularValorDoFrete(){
        return null;
    }

    public Frete buscarFreteDeMaiorValor(){
        return null;
    }

    public List<Frete> getAllFretes() {
        return repository.findAll();
    }
}
