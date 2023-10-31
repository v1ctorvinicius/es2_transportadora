package com.example.atv5.unit;


import com.example.atv5.model.Cliente;
import com.example.atv5.repository.ClienteRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClienteTest {

    @Autowired
    private LocalValidatorFactoryBean validator;

    @Test
    public void deveCriarUmClienteValido() {

        Cliente cliente = Cliente.builder().nome("Fulano Santos").endereco("rua da manga quadra 8").telefone("12345678912").build();
        Set<ConstraintViolation<Cliente>> violations = validator.validate(cliente);
        Assertions.assertNotNull(cliente);
        Assertions.assertTrue(violations.isEmpty());

        Assertions.assertEquals("Fulano Santos", cliente.getNome());
        Assertions.assertEquals("rua da manga quadra 8", cliente.getEndereco());
        Assertions.assertEquals("12345678912", cliente.getTelefone());

    }

    @Test
    public void naoDeveCriarUmClienteComCampoVazio() {

//        Cliente cliente = new Cliente(15L, null, "rua da manga quadra 8", "12345678912");
//        Assertions.assertNull(cliente);
//        Set<ConstraintViolation<Cliente>> violations = validator.validate(cliente);
//        Assertions.assertFalse(violations.isEmpty());
//
//        cliente = new Cliente(16L, "Igor Vladimiro", null, "12345678912");
//        violations = validator.validate(cliente);
//        Assertions.assertFalse(violations.isEmpty());
//
//        cliente = new Cliente(17L, "Igor Vladimiro", "rua da manga quadra 8", null);
//        violations = validator.validate(cliente);
//        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    public void naoDeveCriarClienteComTelefoneInvalido() {
//        Cliente cliente = ClienteBuilder.comNome("Fulano Santos").comEndereco("rua da manga quadra 8").comTelefone("123").build();
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            Cliente cliente = ClienteBuilder.comNome("Fulano Santos").comEndereco("rua da manga quadra 8").comTelefone("123").build();
//        }, "Telefone inválido");
    }
}
