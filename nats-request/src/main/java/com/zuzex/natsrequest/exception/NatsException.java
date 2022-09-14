package com.zuzex.natsrequest.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NatsException extends RuntimeException {

    public NatsException(String message) {
        super(message);
    }
}
