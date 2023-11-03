package com.example.atv5.controller;

import com.example.atv5.model.frete.Frete;
import com.example.atv5.service.frete.FreteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fretes")
public class FreteController {

    private final FreteService service;

    @GetMapping()
    public ResponseEntity<List<Frete>> listarFretes(){
        return ResponseEntity.ok(service.listaFretes());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Frete> cadastrarCidade(@Valid @RequestBody Frete frete) {
        return ResponseEntity.ok(service.cadastraFrete(frete));
    }

    @GetMapping("/por-cliente/{id}")
    public ResponseEntity<List<Frete>> recuperarFretesPorClienteOrdenadoPorValor(@PathVariable Long id){
        return ResponseEntity.ok(service.recuperaFretesPorClienteOrdenadoPorValor(id));
    }

    @GetMapping("/maior-valor")
    public ResponseEntity<Frete> buscarFreteDeMaiorValor(){
        return ResponseEntity.ok(service.recuperaFreteDeMaiorValor());
    }


}
