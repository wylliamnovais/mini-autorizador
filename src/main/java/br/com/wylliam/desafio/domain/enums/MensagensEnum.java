package br.com.wylliam.desafio.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum MensagensEnum {

    CARTAO_JA_CADASTRADO("CARTÃO JÁ CADASTRADO"),
    SENHA_INVALIDA("SENHA INVÁLIDA"),
    NAO_ENCONTRADO("DADOS NÃO ENCONTRADOS COM ID: "),
    SALDO_INSUFICIENTE("SALDO INSUFICIENTE");

    private String descricao;
}
