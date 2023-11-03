package com.example.atv5.integration.repository.cidade;

import com.example.atv5.repository.CidadeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CidadeRepositoryQueryTest {

    @Autowired
    private CidadeRepository repository;

    @Test
    public void deveEncontrarCidadePorNome() {
        var response = repository.findByNome("Salvador");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.size());
        Assertions.assertEquals("Salvador", response.get(0).getNome());
    }
}

