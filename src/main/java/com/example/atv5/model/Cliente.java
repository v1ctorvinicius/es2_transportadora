package com.example.atv5.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_cliente")
    private Long id;

    @NotEmpty(message = "nome é obrigatório")
    @Size(min = 2, max = 30)
    private String nome;

    @NotEmpty(message = "endereço é obrigatório")
    @Size(min = 2, max = 30)
    private String endereco;

    @NotEmpty(message = "telefone é obrigatório")
    @Size(min = 2, max = 30)
    private String telefone;
}
