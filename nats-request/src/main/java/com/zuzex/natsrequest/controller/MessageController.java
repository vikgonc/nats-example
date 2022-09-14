package com.zuzex.natsrequest.controller;

import com.zuzex.natsrequest.dto.RequestMessageDto;
import com.zuzex.natsrequest.dto.ResponseMessageDto;
import com.zuzex.natsrequest.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final RequestService requestService;

    @PostMapping("/message")
    public ResponseMessageDto revertMessage(@RequestBody RequestMessageDto messageDto) {
        return requestService.revertMessage(messageDto);
    }
}
