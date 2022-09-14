package com.zuzex.natsrequest.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.time.Duration;

@Slf4j
@Service
@RequiredArgsConstructor
public class NatsRequestServiceImpl implements RequestService {
    private final Connection connection;
    private final ObjectMapper mapper;

    @Value("${nats.topic}")
    private String topic;

    @Override
    public ResponseMessageDto sendAndTrackTime(RequestMessageDto messageDto) {
        try {
            long startTime = System.currentTimeMillis();
            Message byteResponse = connection.request(topic, mapper.writeValueAsBytes(messageDto.getMessage()), Duration.ofMillis(1000));
            String result = mapper.readValue(byteResponse.getData(), String.class);
            return new ResponseMessageDto(result, System.currentTimeMillis() - startTime);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new NatsException("Nats transfer data error");
        }
    }
}
