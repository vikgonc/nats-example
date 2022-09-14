package com.zuzex.natsreply.configuration;

import io.nats.client.Connection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class NatsConfiguration {

    private final NatsProperties properties;

    @Bean
    public Connection getConnection() {
        return null;
    }
}
