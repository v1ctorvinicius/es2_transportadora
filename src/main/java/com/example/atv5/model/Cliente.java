package com.example.atv5.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @Column(name = "codigo_cliente")
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
}
