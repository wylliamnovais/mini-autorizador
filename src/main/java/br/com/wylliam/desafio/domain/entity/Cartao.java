package br.com.wylliam.desafio.domain.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "cartao")
public class Cartao {

    @Id
    @Column(name = "numeroCartao", nullable = false)
    private String numeroCartao;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "saldo", nullable = true)
    private BigDecimal saldo;

    public Cartao() {
    }

    public Cartao(String numeroCartao, String senha, BigDecimal saldo) {
        this.numeroCartao = numeroCartao;
        this.senha = senha;
        this.saldo = saldo;
    }
}