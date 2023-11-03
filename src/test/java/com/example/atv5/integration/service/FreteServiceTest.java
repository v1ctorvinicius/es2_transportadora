package com.example.atv5.integration.service;

import com.example.atv5.model.Cidade;
import com.example.atv5.model.frete.Frete;
import com.example.atv5.service.frete.FreteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FreteServiceTest {
    @Autowired
    private FreteService freteService;

    @Test
    public void naoDeveCadastrarUmFreteInvalido() {
        Frete freteComCidadeInvalida = Frete.builder().cidadeId(123L).clienteId(1L).descricao("descricao").peso(10.0f).valor(10.0f).build();
        RuntimeException exceptionCidade = Assertions.assertThrows(RuntimeException.class, () -> {
            freteService.cadastraFrete(freteComCidadeInvalida);
        }, "deveria lancar RuntimeException ao tentar cadastrar com uma cidade que não existe");
        Assertions.assertTrue(exceptionCidade.getMessage().contains("Frete inválido"));


        Frete freteComClienteInvalido = Frete.builder().cidadeId(1L).clienteId(123L).descricao("descricao").peso(10.0f).valor(10.0f).build();
        RuntimeException exceptionCliente = Assertions.assertThrows(RuntimeException.class, () -> {
            freteService.cadastraFrete(freteComClienteInvalido);
        }, "deveria lancar RuntimeException ao tentar cadastrar com um cliente que não existe");
        Assertions.assertTrue(exceptionCliente.getMessage().contains("Frete inválido"));
    }

    @Test
    public void deveBuscarOFreteDeMaiorValor() {
        Frete freteDeMaiorValor = freteService.recuperaFreteDeMaiorValor();
        System.out.println("Frete de maior valor: " + freteDeMaiorValor.getValor());
        Assertions.assertNotNull(freteDeMaiorValor);
    }

    @Test
    public void deveCalcularOPrecoDoFrete() {
        Frete frete = Frete.builder().cidadeId(1L).clienteId(1L).descricao("descricao").peso(10.0f).valor(10.0f).build();
        Float precoDoFrete = freteService.calculaPrecoDoFrete(frete);

        Assertions.assertNotNull(precoDoFrete);
        Assertions.assertEquals(102.5f, precoDoFrete);
    }



}
