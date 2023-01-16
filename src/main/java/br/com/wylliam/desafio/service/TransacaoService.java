package br.com.wylliam.desafio.service;

import br.com.wylliam.desafio.domain.dto.CartaoResponseDTO;
import br.com.wylliam.desafio.domain.dto.TransacaoRequestDTO;

public interface TransacaoService {
    CartaoResponseDTO cadastrarTransacao(TransacaoRequestDTO dto);
}
