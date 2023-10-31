package com.example.atv5.unit;


import com.example.atv5.model.Cliente;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Set;

@SpringBootTest
public class ClienteTest {

    @Autowired
    private LocalValidatorFactoryBean validator;

    @Test
    public void deveCriarUmClienteValido() {

        Cliente cliente2 = new Cliente(13L, null, "rua da manga quadra 8", "12345678912");
        Set<ConstraintViolation<Cliente>> violations = validator.validate(cliente2);
        System.out.println("violations: " + violations);

        Cliente cliente = Cliente.builder().nome("Fulano Santos").endereco("rua da manga quadra 8").telefone("12345678912").build();
        Assertions.assertNotNull(cliente);

        Assertions.assertEquals("Fulano Santos", cliente.getNome());
        Assertions.assertEquals("rua da manga quadra 8", cliente.getEndereco());
        Assertions.assertEquals("12345678912", cliente.getTelefone());

    }

    @Test
    public void naoDeveCriarUmClienteComTelefoneVazio() {
//        Cliente cliente = ClienteBuilder.comNome("Fulano Santos").comEndereco("rua da manga quadra 8").comTelefone(null).build();
//        Assertions.assertNotNull(cliente);
    }

    @Test
    public void naoDeveCriarClienteComTelefoneInvalido() {
//        Cliente cliente = ClienteBuilder.comNome("Fulano Santos").comEndereco("rua da manga quadra 8").comTelefone("123").build();
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            Cliente cliente = ClienteBuilder.comNome("Fulano Santos").comEndereco("rua da manga quadra 8").comTelefone("123").build();
//        }, "Telefone inválido");
    }
}
