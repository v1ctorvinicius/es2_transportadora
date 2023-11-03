package com.example.atv5.integration.repository.frete;

import com.example.atv5.model.Cliente;
import com.example.atv5.model.frete.Frete;
import com.example.atv5.repository.FreteRepository;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FreteRepositoryTest {

    @Autowired
    private FreteRepository repository;

    private final Long cidadeId = 1L;
    private final Long clienteId = 1L;
    private final String descricao = "descricao";
    private final Float peso = 10.0f;
    private final Float valor = 10.0f;
    private final int QUANT_FRETES = 10;


    @Test
    public void naoDeveSalvarUmFreteComCidadeIdNulo() {
        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class, () -> {
            Frete frete = Frete.builder().cidadeId(null).clienteId(cidadeId).descricao(descricao).peso(peso).valor(valor).build();
            var response = repository.save(frete);
            Assertions.assertNull(response);
            Assertions.assertEquals(QUANT_FRETES, repository.count());
        }, "deveria lançar constraintViolationException a falta de cidadeId");
        Assertions.assertTrue(e.getMessage().contains("cidade é obrigatória"));
    }

    @Test
    public void naoDeveSalvarUmFreteComClienteIdNulo() {
        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class, () -> {
            Frete frete = Frete.builder().cidadeId(cidadeId).clienteId(null).descricao(descricao).peso(peso).valor(valor).build();
            var response = repository.save(frete);
            Assertions.assertNull(response);
            Assertions.assertEquals(QUANT_FRETES, repository.count());
        }, "deveria lançar constraintViolationException a falta de clienteId");
        Assertions.assertTrue(e.getMessage().contains("cliente é obrigatório"));
    }

    @Test
    public void naoDeveSalvarUmFreteComDescricaoNula() {
        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class, () -> {
            Frete frete = Frete.builder().cidadeId(cidadeId).clienteId(clienteId).descricao(null).peso(peso).valor(valor).build();
            var response = repository.save(frete);
            Assertions.assertNull(response);
            Assertions.assertEquals(QUANT_FRETES, repository.count());
        }, "deveria lançar constraintViolationException a falta de descrição");
        Assertions.assertTrue(e.getMessage().contains("descrição é obrigatória"));
    }

    @Test
    public void naoDeveSalvarUmFreteComPesoNulo() {
        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class, () -> {
            Frete frete = Frete.builder().cidadeId(cidadeId).clienteId(clienteId).descricao(descricao).peso(null).valor(valor).build();
            var response = repository.save(frete);
            Assertions.assertNull(response);
            Assertions.assertEquals(QUANT_FRETES, repository.count());
        }, "deveria lançar constraintViolationException a falta de peso");
        Assertions.assertTrue(e.getMessage().contains("peso é obrigatório"));
    }

    @Test
    public void naoDeveSalvarUmFreteComValorNulo() {
        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class, () -> {
            Frete frete = Frete.builder().cidadeId(1L).clienteId(1L).descricao(descricao).peso(peso).valor(null).build();
            var response = repository.save(frete);
            Assertions.assertNull(response);
            Assertions.assertEquals(QUANT_FRETES, repository.count());
        }, "deveria lançar constraintViolationException a falta de valor");
        Assertions.assertTrue(e.getMessage().contains("valor é obrigatório"));
    }

    @Test
    public void deveRecuperarTodosOsFretes(){

    }

}
