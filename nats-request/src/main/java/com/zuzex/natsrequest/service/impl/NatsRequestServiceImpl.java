package com.zuzex.natsrequest.service.impl;

import com.zuzex.natsrequest.dto.RequestMessageDto;
import com.zuzex.natsrequest.dto.ResponseMessageDto;
import com.zuzex.natsrequest.exception.NatsException;
import com.zuzex.natsrequest.service.RequestService;
import io.nats.client.Connection;
import io.nats.client.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

import java.time.Duration;

@Slf4j
@Service
@RequiredArgsConstructor
public class NatsRequestServiceImpl implements RequestService {
    private final Connection connection;

    @Value("${nats.topic}")
    private String topic;

    @Override
    public ResponseMessageDto revertMessage(RequestMessageDto messageDto) {
        long startTime = System.currentTimeMillis();
        try {
            Message byteResult = connection.request(topic, messageDto.getMessage().getBytes(), Duration.ofMillis(1000));
            String result = (String) SerializationUtils.deserialize(byteResult.getData());
            return new ResponseMessageDto(result, System.currentTimeMillis() - startTime);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new NatsException("Nats transfer data error");
        }
    }
}
