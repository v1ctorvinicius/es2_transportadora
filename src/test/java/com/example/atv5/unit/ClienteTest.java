package com.example.atv5.unit;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClienteTest {

    @Test
    public void deveCriarUmClienteValido() {
        Cliente cliente = ClienteBuilder.comNome("Fulano Santos").comEndereco("rua da manga quadra 8").comTelefone("teste").build();
        Assertions.assertNotNull(cliente);
        // Assert that the attributes are set as expected
        assertEquals("John Doe", cliente.getNome());
        assertEquals("123 Main St", cliente.getEndereco());
        assertEquals("555-1234", cliente.getTelefone());

    }

    @Test
    public void naoDeveCriarUmClienteInvalido() {
        Cliente cliente = ClienteBuilder.comNome("Fulano Santos").comEndereco("rua da manga quadra 8").comTelefone("teste").build();
        Assertions.assertNotNull(cliente);
        // Assert that the attributes are set as expected, even if they are invalid
        assertEquals("", cliente.getNome());
        assertNull(cliente.getEndereco()); // endereco is null
        assertEquals("12345", cliente.getTelefone());
    }

    @Test
    public void naoDeveCriarUmClienteInvalido() {
        Cliente cliente = ClienteBuilder.comNome("Teste").comEndereco("Teste").comTelefone("Teste").build();
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
