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
    private static final String NATS_ERROR_MESSAGE = "Nats transfer data failed";

    private final Connection connection;
    private final ObjectMapper mapper;

    @Value("${nats.topic}")
    private String topic;

    @Override
    public ResponseMessageDto sendReceiveAndTrackTime(RequestMessageDto messageDto) {
        try {
            long startTime = System.currentTimeMillis();
            Message byteReply = connection.request(topic, mapper.writeValueAsBytes(messageDto.getMessage()), Duration.ofMillis(1000));
            String reply = mapper.readValue(byteReply.getData(), String.class);
            log.info("Message '{}' received", reply);
            return new ResponseMessageDto(reply, System.currentTimeMillis() - startTime);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new NatsException(NATS_ERROR_MESSAGE);
        }
    }
}
