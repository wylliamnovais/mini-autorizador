package br.com.wylliam.desafio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestErrorExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler({RegraDeNegocioException.class})
    public ResponseEntity<ResponseError> regraDeNegocioException(RegraDeNegocioException exception) {
        ResponseError responseDefault = new ResponseError(HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase(), exception.getMessage());
        return new ResponseEntity<ResponseError>(responseDefault, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler({NaoEncontradoException.class})
    public ResponseEntity<ResponseError> naoEncontradoExceptionException(NaoEncontradoException exception) {
        ResponseError responseDefault = new ResponseError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), exception.getMessage());
        return new ResponseEntity<ResponseError>(responseDefault, HttpStatus.NOT_FOUND);
    }

}