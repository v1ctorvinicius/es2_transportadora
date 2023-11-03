package com.example.atv5.model.frete;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "cidade é obrigatória")
    private Long cidadeId;

    @Column(name = "codigo_cliente")
    @NotNull(message = "cliente é obrigatório")
    private Long clienteId;

    @NotEmpty(message = "descrição é obrigatória")
    @Size(min = 2, max = 30)
    private String descricao;

    @NotNull(message = "peso é obrigatório")
    private Float peso;

    @NotNull(message = "valor é obrigatório")
    private Float valor;


}
