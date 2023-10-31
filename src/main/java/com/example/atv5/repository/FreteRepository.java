package com.example.atv5.repository;

import com.example.atv5.model.frete.Frete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Long> {
    List<Frete> findAllByClienteIdOrderByValorAsc(Long id);

    @Query("SELECT f FROM Frete f WHERE f.valor = (SELECT MAX(ff.valor) FROM Frete ff)")
    Frete findFreteDeMaiorValor();

}
