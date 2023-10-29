package com.example.atv5.unit;


import com.example.atv5.model.Cliente;
import org.junit.jupiter.api.*;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClienteTest {

    @Test
    public void deveCriarUmClienteValido() {

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


    @BeforeAll
    public static void setup() {

    }

    @BeforeEach
    public void beforeEach() {

    }

    @AfterEach
    public void afterEach() {

    }

    @AfterAll
    public static void close() {

    }


}
