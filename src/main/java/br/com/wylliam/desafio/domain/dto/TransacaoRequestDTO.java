package br.com.wylliam.desafio.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
public class TransacaoRequestDTO {

    @JsonProperty(value = "numeroCartao")
    @NotEmpty(message = "Núumero Cartao não pode estar vazio")
    private String numeroCartao;

    @JsonProperty(value = "senha")
    @NotEmpty(message = "Senha não pode estar vazio")
    private String senha;

    @JsonProperty(value = "valor")
    @NotEmpty(message = "Valor não pode estar vazio")
    private BigDecimal valor;
}