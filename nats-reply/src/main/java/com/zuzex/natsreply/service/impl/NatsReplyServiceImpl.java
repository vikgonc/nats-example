package com.zuzex.natsreply.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zuzex.natsreply.service.ReplyService;
import com.zuzex.natsreply.service.UtilService;
import io.nats.client.Connection;
import io.nats.client.Message;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NatsReplyServiceImpl implements ReplyService {

    @Lazy
    private final Connection connection;
    private final UtilService service;
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    @SneakyThrows
    public void reply(Message message) {
        String payload = mapper.readValue(message.getData(), String.class);
        log.info("Message {} received", payload);
        connection.publish(message.getReplyTo(), mapper.writeValueAsBytes(service.revertString(payload)));
    }
}
