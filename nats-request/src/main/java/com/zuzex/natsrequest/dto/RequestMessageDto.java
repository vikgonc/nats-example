package com.zuzex.natsrequest.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RequestMessageDto {

    @NotBlank
    private String message;
}
