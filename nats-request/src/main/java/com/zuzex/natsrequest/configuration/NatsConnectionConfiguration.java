package com.zuzex.natsrequest.configuration;

import io.nats.client.Connection;
import io.nats.client.Nats;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NatsConnectionConfiguration {

    @Bean
    @SneakyThrows
    public Connection getConnection(@Value("${nats.server}") String server) {
        return Nats.connect(server);
    }
}
