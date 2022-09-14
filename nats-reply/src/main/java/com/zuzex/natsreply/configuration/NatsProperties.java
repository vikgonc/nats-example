package com.zuzex.natsreply.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "nats")
public class NatsProperties {
    private String server;
    private String topic;
}
