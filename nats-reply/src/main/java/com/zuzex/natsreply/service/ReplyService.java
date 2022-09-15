package com.zuzex.natsreply.service;

import io.nats.client.Message;

public interface ReplyService {
    void reply(Message message);
}
