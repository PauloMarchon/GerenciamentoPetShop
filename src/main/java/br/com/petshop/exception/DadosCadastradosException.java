package br.com.petshop.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class DadosCadastradosException extends DataIntegrityViolationException {

    static final long serialVersionUID = 1L;

  public DadosCadastradosException(String msg) {
      super(msg);
  }
    
}
