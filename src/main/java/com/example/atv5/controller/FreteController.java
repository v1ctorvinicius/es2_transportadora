package com.example.atv5.controller;

import com.example.atv5.model.Frete;
import com.example.atv5.service.FreteService;
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
    public ResponseEntity<List<Frete>> getAllFretes(){
        return ResponseEntity.ok(service.getAllFretes());
    }

    @GetMapping("/cadastrar")
    public ResponseEntity<Frete> cadastrarFrete(@RequestBody Frete frete){
        System.out.println(frete.toString());
        return ResponseEntity.ok(service.cadastrarFrete(frete));
    }

}
