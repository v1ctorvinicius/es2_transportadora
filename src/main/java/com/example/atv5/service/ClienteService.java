package com.example.atv5.service;

import com.example.atv5.model.Cliente;
import com.example.atv5.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repo;

    public List<Cliente> listaClientes() {
        return repo.findAll();
    }

    @Transactional
    public Cliente cadastraCliente(Cliente cliente) {
        return repo.save(cliente);
    }
}
