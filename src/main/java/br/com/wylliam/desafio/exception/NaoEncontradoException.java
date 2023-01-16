package br.com.wylliam.desafio.exception;

import br.com.wylliam.desafio.domain.enums.MensagensEnum;

import java.util.logging.Level;
import java.util.logging.Logger;

public class NaoEncontradoException extends RuntimeException {

    private static final Logger log = Logger.getLogger(NaoEncontradoException.class.getName());

    public NaoEncontradoException(String id) {
        super(MensagensEnum.NAO_ENCONTRADO.getDescricao() + id);
        log.log(Level.SEVERE, id);
    }
}
