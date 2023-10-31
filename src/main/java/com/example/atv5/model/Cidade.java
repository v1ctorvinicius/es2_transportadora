package com.example.atv5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cidade {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_cidade")
    private Long id;

    @NotEmpty(message = "nome é obrigatório")
    @Size(min = 2, max = 30)
    private String nome;

    @NotEmpty(message = "UF é obrigatório")
    @Size(min = 2, max = 30)
    private String UF;

    @NotNull(message = "taxa é obrigatória")
    private Float taxa;

}
