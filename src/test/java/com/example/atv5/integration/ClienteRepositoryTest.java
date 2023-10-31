package com.example.atv5.integration;

import com.example.atv5.model.Cliente;
import com.example.atv5.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClienteRepositoryTest {

    private final int QUANT_CLIENTES = 11;

    @Autowired
    private ClienteRepository repository;

    @Test
    public void deveRetornarTodosOsClientes() {
        List<Cliente> clientes = repository.findAll();
        Assertions.assertNotNull(clientes);
        Assertions.assertFalse(clientes.isEmpty());
        Assertions.assertEquals(QUANT_CLIENTES, clientes.size());
    }

    @Test
    public void deveSalvarUmClienteValido() {
        Long numberBeforeSaving = repository.count();
        Cliente cliente = Cliente.builder().nome("Fulano Santos").endereco("rua da manga quadra 8").telefone("12345678912").build();
        repository.save(cliente);
        Long numberAfterSaving = repository.count();
        Assertions.assertEquals(numberBeforeSaving + 1, numberAfterSaving);
    }

    @Test
    public void deveEncontrarUmClientePorTelefone() {

    }
}