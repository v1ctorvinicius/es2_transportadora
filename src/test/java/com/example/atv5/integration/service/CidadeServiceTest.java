package com.example.atv5.integration.service;

import com.example.atv5.model.Cidade;
import com.example.atv5.repository.CidadeRepository;
import com.example.atv5.service.CidadeService;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CidadeServiceTest {

    @Autowired
    private CidadeService service;

    @Autowired
    private CidadeRepository repository;

    private Cidade cidade;

    @BeforeEach
    public void setUp() {
        cidade = Cidade.builder().nome("Sao Luis").UF("MA").taxa(7.0f).build();
    }

    @Test
    public void naoDeveCadastrarUmaCidadeSemTaxa() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            cidade.setTaxa(null);
            service.cadastraCidade(cidade);
        }, "deveria lancar ConstraintViolationException");
    }


}
