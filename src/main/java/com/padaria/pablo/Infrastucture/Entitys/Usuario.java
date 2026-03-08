package com.padaria.pablo.Infrastucture.Entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "usuario")
@Builder

public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "Email", unique = true)
    private String email;

    @Column(name = "CPF", unique = true)
    private String cpf;
}
