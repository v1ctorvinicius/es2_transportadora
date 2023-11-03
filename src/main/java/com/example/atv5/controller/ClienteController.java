package com.example.atv5.controller;

import com.example.atv5.model.Cliente;
import com.example.atv5.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    @PostMapping("/cadastrar")
    public ResponseEntity<Cliente> cadastrarCliente(@Valid @RequestBody Cliente cliente) {
        return ResponseEntity.ok(service.cadastraCliente(cliente));
    }


    @GetMapping()
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(service.listaClientes());
    }



}
