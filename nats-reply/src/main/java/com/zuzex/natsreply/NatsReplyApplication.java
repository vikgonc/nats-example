package com.zuzex.natsreply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class NatsReplyApplication {

    public static void main(String[] args) {
        SpringApplication.run(NatsReplyApplication.class, args);
    }
}
