package com.zuzex.natsreply.configuration;

import com.zuzex.natsreply.service.ReplyService;
import io.nats.client.Connection;
import io.nats.client.Nats;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class NatsConnectionConfiguration {

    private final NatsProperties properties;
    private final ReplyService replyService;

    @Bean
    @SneakyThrows
    public Connection getConnection() {
        Connection connection = Nats.connect(properties.getServer());
        connection.createDispatcher()
                .subscribe(properties.getTopic(), replyService::reply);
        return connection;
    }
}
