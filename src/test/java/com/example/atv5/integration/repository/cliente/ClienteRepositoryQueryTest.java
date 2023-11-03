package com.example.atv5.integration.repository.cliente;

import com.example.atv5.model.Cliente;
import com.example.atv5.repository.ClienteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClienteRepositoryQueryTest {

    @Autowired
    private ClienteRepository repository;

    @Test
    public void deveEncontrarUmClientePorTelefone() {
        Cliente cliente = repository.findByTelefone("(98) 98666-4321");
        Assertions.assertNotNull(cliente);
        Assertions.assertEquals(1L, cliente.getId());
        Assertions.assertEquals("Ana Luiza", cliente.getNome());
    }
}
