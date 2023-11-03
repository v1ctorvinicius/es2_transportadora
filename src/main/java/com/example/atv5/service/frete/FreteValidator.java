package com.example.atv5.service.frete;

import com.example.atv5.model.Cidade;
import com.example.atv5.model.Cliente;
import com.example.atv5.model.frete.Frete;
import com.example.atv5.repository.CidadeRepository;
import com.example.atv5.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FreteValidator {
    private final CidadeRepository cidadeRepository;
    private final ClienteRepository clienteRepository;

    public boolean isValid(Frete frete) {
        Long cidadeId = frete.getCidadeId();
        Long clienteId = frete.getClienteId();

        Optional<Cidade> cidade = cidadeRepository.findById(cidadeId);
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);

        if (cidade.isPresent() && cliente.isPresent()) {
            return true;
        }else {
            throw new RuntimeException("Frete inválido");
        }
    }
}
