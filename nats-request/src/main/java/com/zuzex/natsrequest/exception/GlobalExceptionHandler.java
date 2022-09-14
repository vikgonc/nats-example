package com.zuzex.natsrequest.exception;

import com.zuzex.natsrequest.dto.ResponseErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NatsException.class)
    public ResponseErrorDto handleNatsException(NatsException ex) {
        log.error(ex.getMessage());
        return new ResponseErrorDto(ex.getMessage());
    }
}
