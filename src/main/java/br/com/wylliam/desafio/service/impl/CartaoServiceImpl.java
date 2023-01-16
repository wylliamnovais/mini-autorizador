package br.com.wylliam.desafio.service.impl;

import br.com.wylliam.desafio.domain.dto.CartaoRequestDTO;
import br.com.wylliam.desafio.domain.dto.CartaoResponseDTO;
import br.com.wylliam.desafio.domain.entity.Cartao;
import br.com.wylliam.desafio.exception.NaoEncontradoException;
import br.com.wylliam.desafio.exception.RegraDeNegocioException;
import br.com.wylliam.desafio.repository.CartaoRepository;
import br.com.wylliam.desafio.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CartaoServiceImpl implements CartaoService {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private CartaoRepository cartaoRepository;

    @Override
    public CartaoResponseDTO cadastrarCartao(CartaoRequestDTO dto) {
        try {
            logger.info("[CADASTRANDO CARTÃO]");
            Cartao cartao = new Cartao();
            cartao.setNumeroCartao(dto.getNumeroCartao());
            cartao.setSenha(dto.getSenha());
            cartao.setSaldo(BigDecimal.valueOf(500.00));
            return preencheRetorno(cartaoRepository.save(cartao));
        } catch (Exception ex) {
            throw new RegraDeNegocioException("CARTÃO JÁ CADASTRADO", ex, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public BigDecimal consultarSaldoCartaoPorId(String numeroCartao) {
        logger.info("[CONSULTANDO CARTÃO POR ID] " + numeroCartao);
        Cartao cartao = cartaoRepository.findById(numeroCartao).orElseThrow(() -> new NaoEncontradoException(numeroCartao));
        return cartao.getSaldo();
    }

    private CartaoResponseDTO preencheRetorno(Cartao cartao) {
        CartaoResponseDTO response = new CartaoResponseDTO(cartao.getNumeroCartao(), cartao.getSenha());
        return response;
    }

}
