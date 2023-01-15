package br.com.wylliam.desafio.domain.entity.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "cartao")
public class Cartão {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "numeroCartao", nullable = false)
    private Long numeroCartao;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "saldo", nullable = true)
    private Double saldo;


}