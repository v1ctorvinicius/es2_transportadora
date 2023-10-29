package com.example.atv5.integration;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClienteRepositoryTest {

    @Test
    public void deveRetornarTodosOsClientes() {
        ListarClientes listarClientes = new ListarClientes();
        listarClientes.execute();
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
