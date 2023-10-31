package com.example.atv5.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_cliente")
    private Long id;
    @NotEmpty(message = "nome é obrigatório")
    private String nome;
    @NotNull(message = "endereço é obrigatório")
    private String endereco;
    @NotNull(message = "telefone é obrigatório")
    private String telefone;
}
