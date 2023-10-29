package com.example.atv5.service;

import com.example.atv5.model.Cliente;
import com.example.atv5.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repo;

    public List<Cliente> getAllClientes() {
        return repo.findAll();
    }
}
