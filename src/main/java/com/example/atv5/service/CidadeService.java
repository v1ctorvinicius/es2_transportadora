package com.example.atv5.service;

import com.example.atv5.model.Cidade;
import com.example.atv5.repository.CidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CidadeService {

    private final CidadeRepository repository;

    public List<Cidade> listaCidades() {
        return repository.findAll();
    }

    public Cidade buscarCidadeComMaiorQuantidadeDeFrete(){
        return null;
    }


    public List<Cidade> buscaPorNome(String nome) {
        return repository.findByNome(nome);
    }

    public Cidade cadastraCidade(Cidade cidade) {
        return repository.save(cidade);
    }
}
