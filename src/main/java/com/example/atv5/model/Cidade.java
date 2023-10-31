package com.example.atv5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Getter
@Setter
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

    @NotEmpty(message = "taxa é obrigatória")
    private Float taxa;

}
