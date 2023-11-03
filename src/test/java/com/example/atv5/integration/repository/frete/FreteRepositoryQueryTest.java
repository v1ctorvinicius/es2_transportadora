package com.example.atv5.integration.repository.frete;

import com.example.atv5.model.Cliente;
import com.example.atv5.repository.CidadeRepository;
import com.example.atv5.repository.ClienteRepository;
import com.example.atv5.repository.FreteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class FreteRepositoryQueryTest {

    @Autowired
    private FreteRepository freteRepository;

    @Test
    public void deveRecuperarTodosOsFretesDeUmClienteOrdenadoPorValor() {
        var fretes = freteRepository.findAllByClienteIdOrderByValorAsc(1L);
        Assertions.assertNotNull(fretes);
        Assertions.assertEquals(5, fretes.size());
    }


}
