package com.example.atv5.integration.controller;

import com.example.atv5.controller.CidadeController;
import com.example.atv5.model.Cidade;
import com.example.atv5.repository.CidadeRepository;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CidadeControllerTest {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private TestRestTemplate testRestTemplate;



    @Test
    public void deveListarTodasAsCidades() {
        var response = testRestTemplate.exchange("/cidades", HttpMethod.GET,null, String.class);
        System.out.println("response: " + response.getBody());

    }


}
