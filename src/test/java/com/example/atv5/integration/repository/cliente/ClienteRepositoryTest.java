package com.example.atv5.integration.repository.cliente;

import com.example.atv5.model.Cidade;
import com.example.atv5.model.Cliente;
import com.example.atv5.repository.ClienteRepository;
import jakarta.validation.ConstraintViolationException;
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
    public void deveSalvarUmClienteValido() {
        Long numberBeforeSaving = repository.count();
        Cliente cliente = Cliente.builder().nome("Fulano Santos").endereco("rua da manga numero 8").telefone("12345678912").build();
        repository.save(cliente);
        Long numberAfterSaving = repository.count();
        Assertions.assertEquals(numberBeforeSaving + 1, numberAfterSaving);
    }

    @Test
    public void naoDeveSalvarUmClienteComNomeNulo() {
        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class, () -> {
            Cliente cliente = Cliente.builder().endereco("rua da manga numero 8").telefone("12345678912").build();
            var response = repository.save(cliente);
            Assertions.assertNull(response);
            Assertions.assertEquals(QUANT_CLIENTES, repository.count());
        }, "deveria lançar constraintViolationException a falta de nome");
        Assertions.assertTrue(e.getMessage().contains("nome é obrigatório"));
    }

    @Test
    public void naoDeveSalvarUmClienteComEnderecoNulo() {
        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class, () -> {
            Cliente cliente = Cliente.builder().nome("Fulano Santos").telefone("12345678912").build();
            var response = repository.save(cliente);
            Assertions.assertNull(response);
            Assertions.assertEquals(QUANT_CLIENTES, repository.count());
        }, "deveria lançar constraintViolationException a falta de endereco");
        Assertions.assertTrue(e.getMessage().contains("endereço é obrigatório"));
    }
    @Test
    public void naoDeveSalvarUmClienteComTelefoneNulo() {
        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class, () -> {
            Cliente cliente = Cliente.builder().nome("Fulano Santos").endereco("rua da manga numero 8").build();
            var response = repository.save(cliente);
            Assertions.assertNull(response);
            Assertions.assertEquals(QUANT_CLIENTES, repository.count());
        }, "deveria lançar constraintViolationException a falta de telefone");
        Assertions.assertTrue(e.getMessage().contains("telefone é obrigatório"));
    }
    @Test
    public void deveRetornarTodosOsClientes() {
        List<Cliente> clientes = repository.findAll();
        Assertions.assertNotNull(clientes);
        Assertions.assertFalse(clientes.isEmpty());
        Assertions.assertEquals(QUANT_CLIENTES, clientes.size());
    }
}