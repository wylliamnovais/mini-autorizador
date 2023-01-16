package br.com.wylliam.desafio.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
public class CartaoResponseDTO {

    public CartaoResponseDTO() {
    }

    public CartaoResponseDTO(String numeroCartao, String senha) {
        this.numeroCartao = numeroCartao;
        this.senha = senha;
    }

    public CartaoResponseDTO(String numeroCartao, String senha, BigDecimal saldo) {
        this.numeroCartao = numeroCartao;
        this.senha = senha;
        this.saldo = saldo;
    }

    @JsonProperty(value = "numeroCartao")
    private String numeroCartao;

    @JsonProperty(value = "senha")
    private String senha;

    @JsonProperty(value = "saldo")
    private BigDecimal saldo;
}