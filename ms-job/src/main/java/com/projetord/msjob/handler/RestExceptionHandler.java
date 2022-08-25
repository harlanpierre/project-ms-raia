package com.projetord.msjob.handler;

import com.projetord.msjob.exception.InternalServerErrorException;
import com.projetord.msjob.exception.InternalServerErrorExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<InternalServerErrorExceptionDetails> handlerInternalServerErrorException(InternalServerErrorException inter) {
        return new ResponseEntity<>(
                InternalServerErrorExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .title("Internal Server Erro Exception")
                        .details(inter.getMessage())
                        .developerMessage(inter.getClass().getName())
                        .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
