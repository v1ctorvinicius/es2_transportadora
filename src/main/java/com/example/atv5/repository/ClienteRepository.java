package com.example.atv5.repository;

import com.example.atv5.model.Cidade;
import com.example.atv5.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByTelefone(String telefone);
}
