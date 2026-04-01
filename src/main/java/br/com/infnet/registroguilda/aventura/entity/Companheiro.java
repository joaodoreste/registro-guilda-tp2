package br.com.infnet.registroguilda.aventura.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "companheiros", schema = "aventura")
public class Companheiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "aventureiro_id", nullable = false, unique = true)
    private Aventureiro aventureiro;

    @Column(nullable = false, length = 120)
    private String nome;

    @Column(nullable = false)
    private String especie;

    @Column(name = "indice_lealdade", nullable = false)
    private Integer indiceLealdade;
}