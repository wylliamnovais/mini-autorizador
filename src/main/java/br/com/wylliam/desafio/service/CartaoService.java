package br.com.wylliam.desafio.service;

import br.com.wylliam.desafio.domain.dto.CartaoRequestDTO;
import br.com.wylliam.desafio.domain.dto.CartaoResponseDTO;

import java.math.BigDecimal;

public interface CartaoService {
    public CartaoResponseDTO cadastrarCartao(CartaoRequestDTO dto);

    BigDecimal consultarSaldoCartaoPorId(String numeroCartao);
}
