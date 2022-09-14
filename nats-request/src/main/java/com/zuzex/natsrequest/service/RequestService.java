package com.zuzex.natsrequest.service;

import com.zuzex.natsrequest.dto.RequestMessageDto;
import com.zuzex.natsrequest.dto.ResponseMessageDto;

public interface RequestService {
    ResponseMessageDto revertMessage(RequestMessageDto messageDto);
}
