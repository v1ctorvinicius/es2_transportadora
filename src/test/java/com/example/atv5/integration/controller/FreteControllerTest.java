package com.example.atv5.integration.controller;

import com.example.atv5.model.frete.Frete;
import com.example.atv5.repository.FreteRepository;
import jakarta.validation.Valid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FreteControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private FreteRepository freteRepository;

    @Test
    public void deveListarTodasOsFretes() {

        ResponseEntity<String> response = testRestTemplate.exchange("/fretes", HttpMethod.GET,null, String.class);

        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
        Assertions.assertTrue(Objects.requireNonNull(response.getBody()).split("\n").length > 0);
    }

    @Test
    public void deveCadastrarUmFreteValido() {
        Frete frete = Frete.builder().cidadeId(3L).clienteId(3L).descricao("descricao").peso(10.0f).valor(10.0f).build();
        ResponseEntity<Frete> response = testRestTemplate.postForEntity("/fretes/cadastrar", frete, Frete.class);
        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());

        System.out.println("response: " + response.getBody());
    }

    @Test
    public void deveRecuperarFretesPorClienteId() {
        ResponseEntity<String> response = testRestTemplate.exchange("/fretes/por-cliente/1", HttpMethod.GET,null, String.class);
        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
    }


    @Test
    public void deveRecuperarOFreteDeMaiorValor() {
        ResponseEntity<Frete> response = testRestTemplate.exchange("/fretes/maior-valor", HttpMethod.GET, null, Frete.class);
        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(350.5f, response.getBody().getValor());
    }

}
