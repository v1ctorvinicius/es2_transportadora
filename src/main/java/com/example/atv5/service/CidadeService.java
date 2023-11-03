package com.example.atv5.service;

import com.example.atv5.model.Cidade;
import com.example.atv5.repository.CidadeRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CidadeService {

    private final CidadeRepository repository;

    public List<Cidade> listaCidades() {
        return repository.findAll();
    }

    @Transactional
    public Cidade cadastraCidade(Cidade cidade) {
        return repository.save(cidade);
    }




    public List<Cidade> buscaPorNome(String nome) {
        return repository.findByNome(nome);
    }
}
