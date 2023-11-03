package com.example.atv5.controller;

import com.example.atv5.model.Cidade;
import com.example.atv5.service.CidadeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CidadeController {
    private final CidadeService service;


    public Cidade cadastrarCidade(@Valid Cidade cidade) {
        return service.cadastraCidade(cidade);
    }
    /*
    {
        "nome": "São Luis",
        "taxa": 7.0,
        "uf": "MA"
    }*/


    public List<Cidade> listarCidades() {
        return service.listaCidades();
    }


    public List<Cidade> buscarCidadePorNome(@PathVariable String nome) {
        return service.buscaPorNome(nome);
    }


}
