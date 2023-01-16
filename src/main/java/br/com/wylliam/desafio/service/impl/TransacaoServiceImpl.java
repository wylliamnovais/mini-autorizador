package br.com.wylliam.desafio.service.impl;

import br.com.wylliam.desafio.domain.dto.CartaoResponseDTO;
import br.com.wylliam.desafio.domain.dto.TransacaoRequestDTO;
import br.com.wylliam.desafio.domain.entity.Cartao;
import br.com.wylliam.desafio.domain.enums.MensagensEnum;
import br.com.wylliam.desafio.exception.NaoEncontradoException;
import br.com.wylliam.desafio.exception.RegraDeNegocioException;
import br.com.wylliam.desafio.repository.CartaoRepository;
import br.com.wylliam.desafio.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.logging.Logger;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private CartaoRepository cartaoRepository;


    @Override
    public CartaoResponseDTO cadastrarTransacao(TransacaoRequestDTO dto) {
        synchronized (this) {
            Cartao cartao = new Cartao(dto.getNumeroCartao(), dto.getSenha(), dto.getValor());

            Cartao cartaoValidado = validaConta(cartao);
            validaSenha(cartao, cartaoValidado);
            ajustandoSaldo(cartaoValidado, cartao.getSaldo());

            cartaoRepository.save(cartaoValidado);

            return preencheRetorno(cartaoValidado);
        }
    }

    private Cartao validaConta(Cartao cartao) {
        logger.info("[VERIFICANDO NÚMERO CARTÃO]");
        Cartao cartaoRetorno = cartaoRepository.findById(cartao.getNumeroCartao()).orElseThrow(() -> new NaoEncontradoException(cartao.getNumeroCartao()));
        return cartaoRetorno;
    }

    private void validaSenha(Cartao cartao, Cartao cartaoRetorno) {
        logger.info("[VERIFICANDO SENHA CARTÃO]");
        if (!cartaoRetorno.getSenha().equals(cartao.getSenha()))
            throw new RegraDeNegocioException(MensagensEnum.SENHA_INVALIDA.getDescricao());
    }

    private void ajustandoSaldo(Cartao cartaoRetorno, BigDecimal valorRetirada) {
        logger.info("[AJUSTANDO SALDO CARTÃO]");
        BigDecimal novoValor = valorRetirada.add(cartaoRetorno.getSaldo());
        if (novoValor.signum() < 0)
            throw new RegraDeNegocioException(MensagensEnum.SALDO_INSUFICIENTE.getDescricao());

        cartaoRetorno.setSaldo(novoValor);
    }

    private CartaoResponseDTO preencheRetorno(Cartao cartao) {
        return new CartaoResponseDTO(cartao.getNumeroCartao(), cartao.getSenha(), cartao.getSaldo());
    }

}
