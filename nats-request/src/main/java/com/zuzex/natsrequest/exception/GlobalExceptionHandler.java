package com.zuzex.natsrequest.exception;

import com.zuzex.natsrequest.dto.ResponseErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NatsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseErrorDto handleNatsException(NatsException ex) {
        log.error(ex.getMessage());
        return new ResponseErrorDto(ex.getMessage());
    }
}
