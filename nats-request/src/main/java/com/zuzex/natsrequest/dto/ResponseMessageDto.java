package com.zuzex.natsrequest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseMessageDto {
    private String revertedMessage;
    private long requestTimeMillis;
}
