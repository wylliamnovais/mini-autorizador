package br.com.wylliam.desafio.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CartaoRequestDTO {

    @JsonProperty(value = "numeroCartao")
    @NotEmpty(message = "Núumero Cartao não pode estar vazio")
    private String numeroCartao;

    @JsonProperty(value = "senha")
    @NotEmpty(message = "Senha não pode estar vazio")
    private String senha;
}