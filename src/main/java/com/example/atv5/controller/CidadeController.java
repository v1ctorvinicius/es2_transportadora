package com.example.atv5.controller;

import com.example.atv5.model.Cidade;
import com.example.atv5.service.CidadeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cidades")
public class CidadeController {
    private final CidadeService service;

    @PostMapping("/cadastrar")
    public ResponseEntity<Cidade> cadastrarCidade(@Valid @RequestBody Cidade cidade) {
        return ResponseEntity.ok(service.cadastraCidade(cidade));
    }
    /*
        {
            "nome": "São Luis",
            "taxa": 7.0,
            "uf": "MA"
        }
    */

    @GetMapping()
    public ResponseEntity<List<Cidade>> listarCidades() {
        return ResponseEntity.ok(service.listaCidades());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Cidade>> buscarCidadePorNome(@PathVariable String nome) {
        return ResponseEntity.ok(service.buscaPorNome(nome));
    }






}
