package com.example.atv5.integration.repository.cidade;

import com.example.atv5.model.Cidade;
import com.example.atv5.repository.CidadeRepository;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CidadeRepositoryTest {

    public final int QUANT_CIDADES = 10;

    @Autowired
    private CidadeRepository repository;

    @Test
    public void deveSalvarUmaCidadeValida() {
        Cidade cidade = Cidade.builder().nome("Sao Luis").UF("MA").taxa(7.0f).build();
        var response = repository.save(cidade);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(cidade.getNome(), response.getNome());
        Assertions.assertEquals(cidade.getUF(), response.getUF());
        Assertions.assertEquals(cidade.getTaxa(), response.getTaxa());
        Assertions.assertEquals(QUANT_CIDADES + 1, repository.count());
    }

    @Test
    public void naoDeveSalvarUmaCidadeComNomeNulo() {
        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class, () -> {
            Cidade cidade = Cidade.builder().UF("MA").taxa(7.0f).build();
            var response = repository.save(cidade);
            Assertions.assertNull(response);
            Assertions.assertEquals(QUANT_CIDADES, repository.count());
        }, "deveria lançar constraintViolationException a falta de nome");
        Assertions.assertTrue(e.getMessage().contains("nome é obrigatório"));
    }

    @Test
    public void naoDeveSalvarUmaCidadeComUFNulo() {
        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class, () -> {
            Cidade cidade = Cidade.builder().nome("Sao Luis").taxa(7.0f).build();
            var response = repository.save(cidade);
            Assertions.assertNull(response);
            Assertions.assertEquals(QUANT_CIDADES, repository.count());
        }, "deveria lançar constraintViolationException a falta de UF");
        Assertions.assertTrue(e.getMessage().contains("UF é obrigatório"));
    }

    @Test
    public void naoDeveSalvarUmaCidadeComTaxaNulo() {
        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class, () -> {
            Cidade cidade = Cidade.builder().nome("Sao Luis").UF("MA").build();
            var response = repository.save(cidade);
            Assertions.assertNull(response);
            Assertions.assertEquals(QUANT_CIDADES, repository.count());
        }, "deveria lançar constraintViolationException a falta de taxa");
        Assertions.assertTrue(e.getMessage().contains("taxa é obrigatória"));
    }

}
