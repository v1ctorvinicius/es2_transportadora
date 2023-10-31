package com.example.atv5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Frete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_frete")
    private Long id;

    @Column(name = "codigo_cidade")
    @NotEmpty(message = "cidade é obrigatória")
    private Long cidadeId;

    @Column(name = "codigo_cliente")
    @NotEmpty(message = "cliente é obrigatório")
    private Long clienteId;

    @NotEmpty(message = "descrição é obrigatória")
    @Size(min = 2, max = 30)
    private String descricao;

    @NotEmpty(message = "peso é obrigatório")
    private Float peso;
    private Float valor;
}
